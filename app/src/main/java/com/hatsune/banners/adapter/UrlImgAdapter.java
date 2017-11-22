package com.hatsune.banners.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hatsune.banners.R;
import com.hatsune.caixiaoshuangbanners.XBanners;
import com.hatsune.caixiaoshuangbanners.adapter.LBaseAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 *网络自定义样式
 */

public class UrlImgAdapter implements LBaseAdapter<String> {
    private Context mContext;

    public UrlImgAdapter(Context context) {
        mContext=context;
    }



    @Override
    public View getView(final XBanners lBanners, final Context context, final int position, String data) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.id_image);
        ImageLoader.getInstance().displayImage(data,imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"点击"+position, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }



}
