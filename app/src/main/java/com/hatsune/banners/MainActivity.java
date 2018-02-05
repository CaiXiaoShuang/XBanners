package com.hatsune.banners;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.hatsune.banners.adapter.UrlImgAdapter;
import com.hatsune.caixiaoshuangbanners.XBanners;
import com.hatsune.caixiaoshuangbanners.transformer.TransitionEffect;
import com.hatsune.caixiaoshuangbanners.utils.ScreenUtils;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private XBanners xBanners;
    //本地图片
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    //网络图片
    private List<String> networkImages = new ArrayList<>();

    private static final String[] strs = new String[]{
            "defaultEffect", "alpha", "rotate", "cube", "flip", "accordion", "zoomFade",
            "fade", "zoomCenter", "zoomStack", "stack", "depth", "zoom", "zoomOut", "parallax"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageLoader();
        addLocalImg();
        addUrilImg();

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));



        xBanners = (XBanners) findViewById(R.id.banners);
        //设置Banners高度
        xBanners.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ScreenUtils.dip2px(this, 200)));//高度
        //参数设置
        xBanners.isGuide(false);//是否为引导页
        xBanners.setAutoPlay(true);//自动播放
        xBanners.setVertical(false);//是否锤子播放
        xBanners.setScrollDurtion(2000);//两页切换时间
        xBanners.setCanLoop(true);//循环播放
        xBanners.setSelectIndicatorRes(R.drawable.icon_point_white);//选中的原点
        xBanners.setUnSelectUnIndicatorRes(R.drawable.icon_point);//未选中的原点
        //若自定义原点到底部的距离,默认20,必须在setIndicatorWidth之前调用
        xBanners.setIndicatorBottomPadding(30);
        xBanners.setIndicatorWidth(10,20);//原点默认为5dp
        xBanners.setHoriZontalTransitionEffect(TransitionEffect.ZoomStack);//选中喜欢的样式
//        xBanners.setHoriZontalCustomTransformer(new ParallaxTransformer(R.id.id_image));//自定义样式
        xBanners.setDurtion(3000);//轮播切换时间
//        xBanners.hideIndicatorLayout();//隐藏原点
//        xBanners.showIndicatorLayout();//显示原点
        xBanners.setIndicatorPosition(XBanners.IndicaTorPosition.BOTTOM_MID);//设置原点显示位置


        //本地用法
//        xBanners.setAdapter(new LocalImgAdapter(MainActivity.this), localImages);
        //网络图片
        xBanners.setAdapter(new UrlImgAdapter(MainActivity.this), networkImages);

        xBanners.setOnStartListener(0XFFAABBCC, 0XFFAACCBB, new XBanners.onStartListener() {
            @Override
            public void startOpen() {
                //回调跳转的逻辑
                Toast.makeText(MainActivity.this, "我要进入主界面", Toast.LENGTH_LONG).show();

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.Default);//Default
                        break;
                    case 1:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.Alpha);//Alpha
                        break;
                    case 2:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.Rotate);//Rotate
                        break;
                    case 3:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.Cube);//Cube
                        break;
                    case 4:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.Flip);//Flip
                        break;
                    case 5:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.Accordion);//Accordion
                        break;
                    case 6:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.ZoomFade);//ZoomFade
                        break;
                    case 7:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.Fade);//Fade
                        break;
                    case 8:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.ZoomCenter);//ZoomCenter
                        break;
                    case 9:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.ZoomStack);//ZoomStack
                        break;
                    case 10:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.Stack);//Stack
                        break;
                    case 11:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.Depth);//Depth
                        break;
                    case 12:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.Zoom);//Zoom
                        break;
                    case 13:
                        xBanners.setHoriZontalTransitionEffect(TransitionEffect.ZoomOut);//ZoomOut
                        break;
                    case 14:
                        xBanners.setHoriZontalCustomTransformer(new ParallaxTransformer(R.id.id_image));//Parallax
                        break;

                }
            }
        });


    }


    private void addUrilImg() {
        networkImages.add("http://h.hiphotos.baidu.com/image/h%3D300/sign=ff62800b073b5bb5a1d726fe06d2d523/a6efce1b9d16fdfa7807474eb08f8c5494ee7b23.jpg");
        networkImages.add("http://g.hiphotos.baidu.com/image/h%3D300/sign=0a9ac84f89b1cb1321693a13ed5556da/1ad5ad6eddc451dabff9af4bb2fd5266d0163206.jpg");
        networkImages.add("http://a.hiphotos.baidu.com/image/h%3D300/sign=61660ec2207f9e2f6f351b082f31e962/500fd9f9d72a6059e5c05d3e2f34349b023bbac6.jpg");
        networkImages.add("http://c.hiphotos.baidu.com/image/h%3D300/sign=f840688728738bd4db21b431918a876c/f7246b600c338744c90c3826570fd9f9d62aa09a.jpg");
    }

    private void addLocalImg() {
        localImages.add(R.mipmap.img1);
        localImages.add(R.mipmap.img2);
        localImages.add(R.mipmap.img3);
        localImages.add(R.mipmap.img4);
        localImages.add(R.mipmap.img5);
    }

    private void initImageLoader() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().showImageForEmptyUri(R.mipmap.ic_launcher).cacheInMemory(true).cacheOnDisk(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext()).defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }



    @Override
    protected void onPause() {
        super.onPause();
        xBanners.stopImageTimerTask();//停止图像定时器任务
    }

    @Override
    protected void onResume() {
        super.onResume();
        xBanners.startImageTimerTask();//停止图像定时器任务
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        xBanners.clearImageTimerTask();//停止图像定时器任务
    }


}
