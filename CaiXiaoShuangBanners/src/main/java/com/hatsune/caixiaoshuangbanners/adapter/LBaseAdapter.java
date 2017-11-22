package com.hatsune.caixiaoshuangbanners.adapter;

import android.content.Context;
import android.view.View;
import com.hatsune.caixiaoshuangbanners.XBanners;
public interface LBaseAdapter<T> {
    View getView(XBanners lBanners, Context context, int position, T data);
}
