package com.hatsune.caixiaoshuangbanners.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class AlphaPageTransformer extends LMPageTransformer {
    private float mMinScale = 0.4f;

    public AlphaPageTransformer() {
    }

    public AlphaPageTransformer(float minScale) {
        setMinScale(minScale);
    }

    @Override
    public void scrollInvisible(View view, float position) {
        ViewHelper.setAlpha(view, 0);
    }

    @Override
    public void scrollLeft(View view, float position) {
        ViewHelper.setAlpha(view, mMinScale + (1 - mMinScale) * (1 + position));
    }

    @Override
    public void scrollRight(View view, float position) {
        ViewHelper.setAlpha(view, mMinScale + (1 - mMinScale) * (1 - position));
    }

    public void setMinScale(float minScale) {
        if (minScale >= 0.0f && minScale <= 1.0f) {
            mMinScale = minScale;
        }
    }


}