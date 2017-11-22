package com.hatsune.caixiaoshuangbanners.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class FadePageTransformer extends LMPageTransformer {

    @Override
    public void scrollInvisible(View view, float position) {
    }

    @Override
    public void scrollLeft(View view, float position) {
        ViewHelper.setTranslationX(view, -view.getWidth() * position);
        ViewHelper.setAlpha(view, 1 + position);
    }

    @Override
    public void scrollRight(View view, float position) {
        ViewHelper.setTranslationX(view, -view.getWidth() * position);
        ViewHelper.setAlpha(view, 1 - position);
    }


}