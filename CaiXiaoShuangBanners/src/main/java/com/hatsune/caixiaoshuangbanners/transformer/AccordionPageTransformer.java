package com.hatsune.caixiaoshuangbanners.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class AccordionPageTransformer extends LMPageTransformer {


    @Override
    public void scrollInvisible(View view, float position) {

    }

    @Override
    public void scrollLeft(View view, float position) {
        ViewHelper.setPivotX(view, view.getWidth());
        ViewHelper.setScaleX(view, 1.0f + position);
    }

    @Override
    public void scrollRight(View view, float position) {
        ViewHelper.setPivotX(view, 0);
        ViewHelper.setScaleX(view, 1.0f - position);
        ViewHelper.setAlpha(view, 1);
    }

}