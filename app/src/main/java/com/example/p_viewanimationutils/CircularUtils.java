package com.example.p_viewanimationutils;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;



public class CircularUtils {
    private View mContainer;
    private Context mContext;
    private Animator mAnimator;
    public final static int CircularUtils_START = 0;
    public final static int CircularUtils_END = 1;

    public CircularUtils(Context context, View container, View box, int type) {
        this.mContainer = container;
        this.mContext = context;
        this.mAnimator = getMAnimator(container, box, type);

    }

    public CircularUtils(Context context, View container, View box) {
        this.mContainer = container;
        this.mContext = context;
        this.mAnimator = getMAnimator(container, box);
    }

    private Animator getMAnimator(View container, View box) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.mAnimator = ViewAnimationUtils.createCircularReveal(container, container.getRight() / 2, container.getBottom() / 6, 0, (float) Math.hypot(box.getWidth(), box.getHeight()));
        }
        return mAnimator;
    }

    private Animator getMAnimator(View container, View box, int type) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            switch (type) {
                case CircularUtils_START:
                    this.mAnimator = ViewAnimationUtils.createCircularReveal(container, container.getRight() / 2, container.getBottom() / 6, 0, (float) Math.hypot(box.getWidth(), box.getHeight()));
                    break;
                case CircularUtils_END:
                    this.mAnimator = ViewAnimationUtils.createCircularReveal(container, container.getRight() / 2, container.getBottom() / 6, (float) Math.hypot(box.getWidth(), box.getHeight()), 0);
                    break;
            }
        }
        return mAnimator;
    }

    public Animator setDuration(int time) {
        if (mAnimator != null) mAnimator.setDuration(time);
        return mAnimator;
    }

    public void start() {
        if (mAnimator != null) mAnimator.start();
    }

    public void addListener(Animator.AnimatorListener listener) {
        if (mAnimator != null) this.mAnimator.addListener(listener);
    }

    /*設定Circular背景元件及特效顏色
     * @param Views 預變成灰色特效背景的元件
     * @param color 特效顏色
     */
    public void setStartAnimationColor(View[] views, int color) {
        for (View v : views) {
            setBackgroundColor(v, color);
        }
    }

    /*移出特效完的背景顏色
     * @param views 預被移除背景特效顏色的原件
     * */
    public void reMoveAnimationBackgroundColor(View[] views) {
        for (View v : views) {
            v.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private void setBackgroundColor(View view, int color) {
        view.setBackgroundColor(mContext.getResources().getColor(color));
    }

    public static abstract class MAnimatorListener implements Animator.AnimatorListener {

        @Override
        public void onAnimationStart(Animator animator) {
            onAnimationStarts(animator);
        }

        @Override
        public void onAnimationEnd(Animator animator) {
            onAnimationEnds(animator);
        }

        @Override
        public void onAnimationCancel(Animator animator) {

        }

        @Override
        public void onAnimationRepeat(Animator animator) {

        }

        public abstract void onAnimationStarts(Animator animator);

        public abstract void onAnimationEnds(Animator animator);

    }

}