package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.ImageView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private TintInfo mTmpInfo;
    private final ImageView mView;

    public AppCompatImageHelper(ImageView view) {
        this.mView = view;
    }

    public void loadFromAttributes(AttributeSet attrs, int defStyleAttr) {
        int id;
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attrs, R.styleable.AppCompatImageView, defStyleAttr, 0);
        try {
            Drawable drawable = this.mView.getDrawable();
            if (drawable == null && (id = a.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AppCompatResources.getDrawable(this.mView.getContext(), id)) != null) {
                this.mView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            if (a.hasValue(R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.setImageTintList(this.mView, a.getColorStateList(R.styleable.AppCompatImageView_tint));
            }
            if (a.hasValue(R.styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(a.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a.recycle();
        }
    }

    public void setImageResource(int resId) {
        if (resId != 0) {
            Drawable d = AppCompatResources.getDrawable(this.mView.getContext(), resId);
            if (d != null) {
                DrawableUtils.fixDrawable(d);
            }
            this.mView.setImageDrawable(d);
        } else {
            this.mView.setImageDrawable(null);
        }
        applySupportImageTint();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasOverlappingRendering() {
        Drawable background = this.mView.getBackground();
        if (Build.VERSION.SDK_INT >= 21 && (background instanceof RippleDrawable)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportImageTintList(ColorStateList tint) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintList = tint;
        tintInfo.mHasTintList = true;
        applySupportImageTint();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getSupportImageTintList() {
        TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportImageTintMode(PorterDuff.Mode tintMode) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintMode = tintMode;
        tintInfo.mHasTintMode = true;
        applySupportImageTint();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportImageTintMode() {
        TintInfo tintInfo = this.mImageTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applySupportImageTint() {
        Drawable imageViewDrawable = this.mView.getDrawable();
        if (imageViewDrawable != null) {
            DrawableUtils.fixDrawable(imageViewDrawable);
        }
        if (imageViewDrawable != null) {
            if (shouldApplyFrameworkTintUsingColorFilter() && applyFrameworkTintUsingColorFilter(imageViewDrawable)) {
                return;
            }
            TintInfo tintInfo = this.mImageTint;
            if (tintInfo != null) {
                AppCompatDrawableManager.tintDrawable(imageViewDrawable, tintInfo, this.mView.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.mInternalImageTint;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.tintDrawable(imageViewDrawable, tintInfo2, this.mView.getDrawableState());
            }
        }
    }

    void setInternalImageTint(ColorStateList tint) {
        if (tint != null) {
            if (this.mInternalImageTint == null) {
                this.mInternalImageTint = new TintInfo();
            }
            TintInfo tintInfo = this.mInternalImageTint;
            tintInfo.mTintList = tint;
            tintInfo.mHasTintList = true;
        } else {
            this.mInternalImageTint = null;
        }
        applySupportImageTint();
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int sdk = Build.VERSION.SDK_INT;
        return sdk > 21 ? this.mInternalImageTint != null : sdk == 21;
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable imageSource) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new TintInfo();
        }
        TintInfo info = this.mTmpInfo;
        info.clear();
        ColorStateList tintList = ImageViewCompat.getImageTintList(this.mView);
        if (tintList != null) {
            info.mHasTintList = true;
            info.mTintList = tintList;
        }
        PorterDuff.Mode mode = ImageViewCompat.getImageTintMode(this.mView);
        if (mode != null) {
            info.mHasTintMode = true;
            info.mTintMode = mode;
        }
        if (info.mHasTintList || info.mHasTintMode) {
            AppCompatDrawableManager.tintDrawable(imageSource, info, this.mView.getDrawableState());
            return true;
        }
        return false;
    }
}