package android.arch.lifecycle;

import android.arch.core.internal.SafeIterableMap;
import android.support.annotation.CallSuper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources = new SafeIterableMap<>();

    @MainThread
    public <S> void addSource(@NonNull LiveData<S> source, @NonNull Observer<S> onChanged) {
        Source<?> source2 = new Source<>(source, onChanged);
        Source<?> existing = this.mSources.putIfAbsent(source, source2);
        if (existing != null && existing.mObserver != onChanged) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (existing == null && hasActiveObservers()) {
            source2.plug();
        }
    }

    @MainThread
    public <S> void removeSource(@NonNull LiveData<S> toRemote) {
        Source<?> source = this.mSources.remove(toRemote);
        if (source != null) {
            source.unplug();
        }
    }

    @Override // android.arch.lifecycle.LiveData
    @CallSuper
    protected void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            Map.Entry<LiveData<?>, Source<?>> source = it.next();
            source.getValue().plug();
        }
    }

    @Override // android.arch.lifecycle.LiveData
    @CallSuper
    protected void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            Map.Entry<LiveData<?>, Source<?>> source = it.next();
            source.getValue().unplug();
        }
    }

    /* loaded from: classes2.dex */
    private static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<V> mObserver;
        int mVersion = -1;

        Source(LiveData<V> liveData, Observer<V> observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        void plug() {
            this.mLiveData.observeForever(this);
        }

        void unplug() {
            this.mLiveData.removeObserver(this);
        }

        @Override // android.arch.lifecycle.Observer
        public void onChanged(@Nullable V v) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v);
            }
        }
    }
}