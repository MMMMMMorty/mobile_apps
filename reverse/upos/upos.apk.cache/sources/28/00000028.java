package android.arch.lifecycle;

import android.arch.core.executor.ArchTaskExecutor;
import android.arch.core.internal.SafeIterableMap;
import android.arch.lifecycle.Lifecycle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    private static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    private volatile Object mData;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;
    private final Object mDataLock = new Object();
    private SafeIterableMap<Observer<T>, LiveData<T>.ObserverWrapper> mObservers = new SafeIterableMap<>();
    private int mActiveCount = 0;

    public LiveData() {
        Object obj = NOT_SET;
        this.mData = obj;
        this.mPendingData = obj;
        this.mVersion = -1;
        this.mPostValueRunnable = new Runnable() { // from class: android.arch.lifecycle.LiveData.1
            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: android.arch.lifecycle.LiveData */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LiveData.this.mDataLock) {
                    try {
                        try {
                            Object newValue = LiveData.this.mPendingData;
                            LiveData.this.mPendingData = LiveData.NOT_SET;
                            LiveData.this.setValue(newValue);
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: android.arch.lifecycle.Observer<T> */
    /* JADX WARN: Multi-variable type inference failed */
    private void considerNotify(LiveData<T>.ObserverWrapper observer) {
        if (!observer.mActive) {
            return;
        }
        if (!observer.shouldBeActive()) {
            observer.activeStateChanged(false);
            return;
        }
        int i = observer.mLastVersion;
        int i2 = this.mVersion;
        if (i >= i2) {
            return;
        }
        observer.mLastVersion = i2;
        observer.mObserver.onChanged(this.mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchingValue(@Nullable LiveData<T>.ObserverWrapper initiator) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (initiator != null) {
                considerNotify(initiator);
                initiator = null;
            } else {
                Iterator<Map.Entry<Observer<T>, LiveData<T>.ObserverWrapper>> iterator = this.mObservers.iteratorWithAdditions();
                while (iterator.hasNext()) {
                    considerNotify(iterator.next().getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    @MainThread
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<T> observer) {
        if (owner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        LiveData<T>.LifecycleBoundObserver wrapper = new LifecycleBoundObserver(owner, observer);
        LiveData<T>.ObserverWrapper existing = this.mObservers.putIfAbsent(observer, wrapper);
        if (existing != null && !existing.isAttachedTo(owner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (existing != null) {
            return;
        }
        owner.getLifecycle().addObserver(wrapper);
    }

    @MainThread
    public void observeForever(@NonNull Observer<T> observer) {
        LiveData<T>.AlwaysActiveObserver wrapper = new AlwaysActiveObserver(observer);
        LiveData<T>.ObserverWrapper existing = this.mObservers.putIfAbsent(observer, wrapper);
        if (existing != null && (existing instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (existing != null) {
            return;
        }
        wrapper.activeStateChanged(true);
    }

    @MainThread
    public void removeObserver(@NonNull Observer<T> observer) {
        assertMainThread("removeObserver");
        LiveData<T>.ObserverWrapper removed = this.mObservers.remove(observer);
        if (removed == null) {
            return;
        }
        removed.detachObserver();
        removed.activeStateChanged(false);
    }

    @MainThread
    public void removeObservers(@NonNull LifecycleOwner owner) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<Observer<T>, LiveData<T>.ObserverWrapper>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            Map.Entry<Observer<T>, LiveData<T>.ObserverWrapper> entry = it.next();
            if (entry.getValue().isAttachedTo(owner)) {
                removeObserver(entry.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postValue(T value) {
        synchronized (this.mDataLock) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                boolean postTask = this.mPendingData == NOT_SET;
                this.mPendingData = value;
                if (!postTask) {
                    return;
                }
                ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @MainThread
    public void setValue(T value) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = value;
        dispatchingValue(null);
    }

    @Nullable
    public T getValue() {
        T t = (T) this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersion() {
        return this.mVersion;
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements GenericLifecycleObserver {
        @NonNull
        final LifecycleOwner mOwner;

        LifecycleBoundObserver(@NonNull LifecycleOwner owner, Observer<T> observer) {
            super(observer);
            this.mOwner = owner;
        }

        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // android.arch.lifecycle.GenericLifecycleObserver
        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            if (this.mOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.mObserver);
            } else {
                activeStateChanged(shouldBeActive());
            }
        }

        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        boolean isAttachedTo(LifecycleOwner owner) {
            return this.mOwner == owner;
        }

        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class ObserverWrapper {
        boolean mActive;
        int mLastVersion = -1;
        final Observer<T> mObserver;

        abstract boolean shouldBeActive();

        ObserverWrapper(Observer<T> observer) {
            this.mObserver = observer;
        }

        boolean isAttachedTo(LifecycleOwner owner) {
            return false;
        }

        void detachObserver() {
        }

        void activeStateChanged(boolean newActive) {
            if (newActive == this.mActive) {
                return;
            }
            this.mActive = newActive;
            boolean wasInactive = LiveData.this.mActiveCount == 0;
            LiveData.this.mActiveCount += this.mActive ? 1 : -1;
            if (wasInactive && this.mActive) {
                LiveData.this.onActive();
            }
            if (LiveData.this.mActiveCount == 0 && !this.mActive) {
                LiveData.this.onInactive();
            }
            if (this.mActive) {
                LiveData.this.dispatchingValue(this);
            }
        }
    }

    /* loaded from: classes.dex */
    private class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        AlwaysActiveObserver(Observer<T> observer) {
            super(observer);
        }

        @Override // android.arch.lifecycle.LiveData.ObserverWrapper
        boolean shouldBeActive() {
            return true;
        }
    }

    private static void assertMainThread(String methodName) {
        if (!ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException("Cannot invoke " + methodName + " on a background thread");
        }
    }
}