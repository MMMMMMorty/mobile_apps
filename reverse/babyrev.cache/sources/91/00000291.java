package android.support.v4.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.GuardedBy;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private final int mDestructAfterMillisec;
    @GuardedBy("mLock")
    private Handler mHandler;
    private final int mPriority;
    @GuardedBy("mLock")
    private HandlerThread mThread;
    private final String mThreadName;
    private final Object mLock = new Object();
    private Handler.Callback mCallback = new Handler.Callback() { // from class: android.support.v4.provider.SelfDestructiveThread.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    SelfDestructiveThread.this.onDestruction();
                    return true;
                case 1:
                    SelfDestructiveThread.this.onInvokeRunnable((Runnable) msg.obj);
                    return true;
                default:
                    return true;
            }
        }
    };
    @GuardedBy("mLock")
    private int mGeneration = 0;

    /* loaded from: classes2.dex */
    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public SelfDestructiveThread(String threadName, int priority, int destructAfterMillisec) {
        this.mThreadName = threadName;
        this.mPriority = priority;
        this.mDestructAfterMillisec = destructAfterMillisec;
    }

    @VisibleForTesting
    public boolean isRunning() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mThread != null;
        }
        return z;
    }

    @VisibleForTesting
    public int getGeneration() {
        int i;
        synchronized (this.mLock) {
            i = this.mGeneration;
        }
        return i;
    }

    private void post(Runnable runnable) {
        synchronized (this.mLock) {
            if (this.mThread == null) {
                this.mThread = new HandlerThread(this.mThreadName, this.mPriority);
                this.mThread.start();
                this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
                this.mGeneration++;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, runnable));
        }
    }

    public <T> void postAndReply(final Callable<T> callable, final ReplyCallback<T> reply) {
        final Handler callingHandler = new Handler();
        post(new Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.2
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                try {
                    obj = callable.call();
                } catch (Exception e) {
                    obj = null;
                }
                final Object obj2 = obj;
                callingHandler.post(new Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        reply.onReply(obj2);
                    }
                });
            }
        });
    }

    public <T> T postAndWait(final Callable<T> callable, int timeoutMillis) throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        final Condition cond = lock.newCondition();
        final AtomicReference<T> holder = new AtomicReference<>();
        final AtomicBoolean running = new AtomicBoolean(true);
        post(new Runnable() { // from class: android.support.v4.provider.SelfDestructiveThread.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    holder.set(callable.call());
                } catch (Exception e) {
                }
                lock.lock();
                try {
                    running.set(false);
                    cond.signal();
                } finally {
                    lock.unlock();
                }
            }
        });
        lock.lock();
        try {
            if (!running.get()) {
                return holder.get();
            }
            long remaining = TimeUnit.MILLISECONDS.toNanos(timeoutMillis);
            do {
                try {
                    remaining = cond.awaitNanos(remaining);
                } catch (InterruptedException e) {
                }
                if (!running.get()) {
                    return holder.get();
                }
            } while (remaining > 0);
            throw new InterruptedException("timeout");
        } finally {
            lock.unlock();
        }
    }

    void onInvokeRunnable(Runnable runnable) {
        runnable.run();
        synchronized (this.mLock) {
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), this.mDestructAfterMillisec);
        }
    }

    void onDestruction() {
        synchronized (this.mLock) {
            if (this.mHandler.hasMessages(1)) {
                return;
            }
            this.mThread.quit();
            this.mThread = null;
            this.mHandler = null;
        }
    }
}