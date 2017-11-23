package com.hatsune.caixiaoshuangbanners.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class ZoomOutPageTransformer extends LMPageTransformer {

    private static float MIN_SCALE = 0.85f;

    private static float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // 这个页面在屏幕左边。
            ViewHelper.setAlpha(view,0);
        } else if (position <= 1) { // [-1,1]
            // 修改默认幻灯片转换到
            // 收缩页面
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                ViewHelper.setTranslationX(view,horzMargin - vertMargin / 2);
            } else {
                ViewHelper.setTranslationX(view,-horzMargin + vertMargin / 2);
            }
            // 量表的下一页（min_scale和1之间）
            ViewHelper.setScaleX(view,scaleFactor);
            ViewHelper.setScaleY(view,scaleFactor);


            //使页面相对于它的大小淡入。
            ViewHelper.setAlpha(view,MIN_ALPHA + (scaleFactor - MIN_SCALE)
                    / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            // 这一页离右边的屏幕太远了。
            ViewHelper.setAlpha(view,0);
        }
    }

    @Override
    public void scrollInvisible(View view, float position) {

    }

    @Override
    public void scrollLeft(View view, float position) {

    }

    @Override
    public void scrollRight(View view, float position) {

    }
}
