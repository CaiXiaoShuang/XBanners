package com.hatsune.banners.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hatsune.banners.R;
import com.hatsune.caixiaoshuangbanners.XBanners;
import com.hatsune.caixiaoshuangbanners.adapter.LBaseAdapter;


/**
 *本地自定义样式
 */
public class LocalImgAdapter implements LBaseAdapter<Integer> {

    private Context mContext;
    public LocalImgAdapter(Context context) {
        mContext=context;
    }

    @Override
    public View getView(final XBanners lBanners, final Context context, final int position, Integer data) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.id_image);
        imageView.setImageResource(data);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"点击"+position, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


}
