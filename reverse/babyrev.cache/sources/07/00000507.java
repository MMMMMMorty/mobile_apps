package android.support.v7.widget;

import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static final long HOVER_HIDE_TIMEOUT_MS = 15000;
    private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000;
    private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500;
    private static final String TAG = "TooltipCompatHandler";
    private static TooltipCompatHandler sActiveHandler;
    private static TooltipCompatHandler sPendingHandler;
    private final View mAnchor;
    private int mAnchorX;
    private int mAnchorY;
    private boolean mFromTouch;
    private final int mHoverSlop;
    private TooltipPopup mPopup;
    private final CharSequence mTooltipText;
    private final Runnable mShowRunnable = new Runnable() { // from class: android.support.v7.widget.TooltipCompatHandler.1
        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.show(false);
        }
    };
    private final Runnable mHideRunnable = new Runnable() { // from class: android.support.v7.widget.TooltipCompatHandler.2
        @Override // java.lang.Runnable
        public void run() {
            TooltipCompatHandler.this.hide();
        }
    };

    public static void setTooltipText(View view, CharSequence tooltipText) {
        TooltipCompatHandler tooltipCompatHandler = sPendingHandler;
        if (tooltipCompatHandler != null && tooltipCompatHandler.mAnchor == view) {
            setPendingHandler(null);
        }
        if (TextUtils.isEmpty(tooltipText)) {
            TooltipCompatHandler tooltipCompatHandler2 = sActiveHandler;
            if (tooltipCompatHandler2 != null && tooltipCompatHandler2.mAnchor == view) {
                tooltipCompatHandler2.hide();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new TooltipCompatHandler(view, tooltipText);
    }

    private TooltipCompatHandler(View anchor, CharSequence tooltipText) {
        this.mAnchor = anchor;
        this.mTooltipText = tooltipText;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(this.mAnchor.getContext()));
        clearAnchorPos();
        this.mAnchor.setOnLongClickListener(this);
        this.mAnchor.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        this.mAnchorX = v.getWidth() / 2;
        this.mAnchorY = v.getHeight() / 2;
        show(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View v, MotionEvent event) {
        if (this.mPopup == null || !this.mFromTouch) {
            AccessibilityManager manager = (AccessibilityManager) this.mAnchor.getContext().getSystemService("accessibility");
            if (manager.isEnabled() && manager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = event.getAction();
            if (action != 7) {
                if (action == 10) {
                    clearAnchorPos();
                    hide();
                }
            } else if (this.mAnchor.isEnabled() && this.mPopup == null && updateAnchorPos(event)) {
                setPendingHandler(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        hide();
    }

    void show(boolean fromTouch) {
        long timeout;
        if (!ViewCompat.isAttachedToWindow(this.mAnchor)) {
            return;
        }
        setPendingHandler(null);
        TooltipCompatHandler tooltipCompatHandler = sActiveHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.hide();
        }
        sActiveHandler = this;
        this.mFromTouch = fromTouch;
        this.mPopup = new TooltipPopup(this.mAnchor.getContext());
        this.mPopup.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
        this.mAnchor.addOnAttachStateChangeListener(this);
        if (this.mFromTouch) {
            timeout = LONG_CLICK_HIDE_TIMEOUT_MS;
        } else if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) == 1) {
            timeout = HOVER_HIDE_TIMEOUT_SHORT_MS - ViewConfiguration.getLongPressTimeout();
        } else {
            timeout = HOVER_HIDE_TIMEOUT_MS - ViewConfiguration.getLongPressTimeout();
        }
        this.mAnchor.removeCallbacks(this.mHideRunnable);
        this.mAnchor.postDelayed(this.mHideRunnable, timeout);
    }

    void hide() {
        if (sActiveHandler == this) {
            sActiveHandler = null;
            TooltipPopup tooltipPopup = this.mPopup;
            if (tooltipPopup != null) {
                tooltipPopup.hide();
                this.mPopup = null;
                clearAnchorPos();
                this.mAnchor.removeOnAttachStateChangeListener(this);
            } else {
                Log.e(TAG, "sActiveHandler.mPopup == null");
            }
        }
        if (sPendingHandler == this) {
            setPendingHandler(null);
        }
        this.mAnchor.removeCallbacks(this.mHideRunnable);
    }

    private static void setPendingHandler(TooltipCompatHandler handler) {
        TooltipCompatHandler tooltipCompatHandler = sPendingHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.cancelPendingShow();
        }
        sPendingHandler = handler;
        TooltipCompatHandler tooltipCompatHandler2 = sPendingHandler;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.scheduleShow();
        }
    }

    private void scheduleShow() {
        this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
    }

    private void cancelPendingShow() {
        this.mAnchor.removeCallbacks(this.mShowRunnable);
    }

    private boolean updateAnchorPos(MotionEvent event) {
        int newAnchorX = (int) event.getX();
        int newAnchorY = (int) event.getY();
        if (Math.abs(newAnchorX - this.mAnchorX) <= this.mHoverSlop && Math.abs(newAnchorY - this.mAnchorY) <= this.mHoverSlop) {
            return false;
        }
        this.mAnchorX = newAnchorX;
        this.mAnchorY = newAnchorY;
        return true;
    }

    private void clearAnchorPos() {
        this.mAnchorX = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mAnchorY = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }
}