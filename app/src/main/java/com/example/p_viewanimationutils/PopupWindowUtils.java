package com.example.p_viewanimationutils;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;


public class PopupWindowUtils extends PopupWindow {
    private PopupWindow ppupWindow;
    private View viewContainer, layoutView;
    private Context context;

    private boolean isShowing;

    public PopupWindowUtils(Context context, View viewContainer, int layoutId) {
        this.context = context;
        this.viewContainer = viewContainer;
        this.layoutView = LayoutInflater.from(context).inflate(layoutId, null);
        ppupWindow = new PopupWindow(layoutView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        initTouch();
    }


    public View getLayoutView() {
        return layoutView;
    }

    public void showLocation(int gravity) {
        if (ppupWindow != null) {
            ppupWindow.showAtLocation(viewContainer, gravity, 0, 0);
        }
    }

    public void disMiss() {
        if (ppupWindow != null) {
            ppupWindow.dismiss();
        }
    }

    public PopupWindow setTouchModel(boolean touchModel) {
        if (ppupWindow != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                ppupWindow.setTouchModal(touchModel);

            }
        }
        return ppupWindow;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        if (ppupWindow != null) {
            ppupWindow.setOnDismissListener(onDismissListener);
        }
    }

    public boolean isShowing() {
        if (ppupWindow != null) {
            isShowing = ppupWindow.isShowing();
        }
        return isShowing;
    }

    private void initTouch() {
        this.setTouchModel(true);
        this.ppupWindow.setFocusable(true);
        this.ppupWindow.setOutsideTouchable(true);
        this.ppupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }


}