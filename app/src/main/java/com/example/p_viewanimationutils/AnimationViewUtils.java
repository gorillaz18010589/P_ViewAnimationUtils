package com.example.p_viewanimationutils;

import android.view.Window;
import android.view.WindowManager;

public class AnimationViewUtils {
    public static AnimationViewUtils instance;

    public static AnimationViewUtils getInstance(){
        if(instance == null){
            instance = new AnimationViewUtils();
        }
        return instance;
    }

    public AnimationViewUtils() {

    }

    public void removeShadow(Window window) {
        final WindowManager.LayoutParams params = window.getAttributes();
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        params.dimAmount = 1.0f;
        params.alpha = 1.0f;
        window.setAttributes(params);

    }

    public void initShadow(Window window) {
        final WindowManager.LayoutParams params = window.getAttributes();
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        params.dimAmount = 0.7f;
        params.alpha = 0.5f;
        window.setAttributes(params);
    }

}