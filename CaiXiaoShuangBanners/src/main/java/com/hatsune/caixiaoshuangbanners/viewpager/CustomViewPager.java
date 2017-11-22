package com.hatsune.caixiaoshuangbanners.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 可锤子滑动，可禁滑动的Viewpager
 */
public class CustomViewPager extends ViewPager {
    private boolean isScrollEnabled = true;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isScrollEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isScrollEnabled && super.onInterceptTouchEvent(event);

    }

    public void setScrollEnabled(boolean b) {
        this.isScrollEnabled = b;
    }}
