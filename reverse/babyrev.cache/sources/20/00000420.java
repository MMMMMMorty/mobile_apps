package android.support.v7.view.menu;

/* loaded from: classes2.dex */
class BaseWrapper<T> {
    final T mWrappedObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseWrapper(T object) {
        if (object == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.mWrappedObject = object;
    }

    public T getWrappedObject() {
        return this.mWrappedObject;
    }
}