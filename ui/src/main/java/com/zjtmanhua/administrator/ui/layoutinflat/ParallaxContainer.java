package com.zjtmanhua.administrator.ui.layoutinflat;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.nineoldandroids.view.ViewHelper;
import com.zjtmanhua.administrator.ui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 * 容器
 * 引导页的最外层布局
 */

public class ParallaxContainer extends FrameLayout implements OnPageChangeListener {

    private List<ParallaxFragment> fragments;
    private ParallaxPagerAdapter adapter;
    private float containerWidth;
    private ImageView iv_man;


    public ParallaxContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 指定引导页的所有页面布局文件
     */

    public void setUp(int... childIds){
        //根据布局文件数组，初始化所有的fragment
        fragments=new ArrayList<ParallaxFragment>();
        //填充frament
        for(int i=0;i<childIds.length;i++){
            ParallaxFragment f=new ParallaxFragment();
            Bundle args=new Bundle();
            //页面索引
            args.putInt("index",i);
            //布局id
            args.putInt("layoutId",childIds[i]);
            f.setArguments(args);
            fragments.add(f);
        }
        //实例化适配器
        SplashActivity activity=(SplashActivity)getContext();
        adapter=new ParallaxPagerAdapter(activity.getSupportFragmentManager(),fragments);
        //实例化Viewpager
       ViewPager vp=new ViewPager(getContext());
        vp.setId(R.id.parallax_pager);
        vp.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

        //绑定
        vp.setAdapter(adapter);
        addView(vp,0);
        vp.setOnPageChangeListener(this);






    }

    /**
     * 页面滚动
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     * 设置页面滚动时的动画
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    this.containerWidth=getWidth();
        //在翻页过程中，不断通过视图中的标签，改变视图的位置或者透明度
        //获取进入的界面
        ParallaxFragment infragment=null;
        try {
            infragment=fragments.get(position-1);
        }catch (Exception e){
            e.printStackTrace();
        }
        //获取退出来的界面
        ParallaxFragment outfragment=null;
        try {
            outfragment=fragments.get(position);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(infragment!=null) {
            List<View> inViews = infragment.getParallaxViews();

            if (inViews != null) {


                for (View view : inViews) {
                    //获取标签，从标签上获取所有的动画
                    ParallaxViewTag tag = (ParallaxViewTag) view.getTag(R.id.parallax_view_tag);
                    if (tag != null) {
                        continue;
                    }
                    //translationY改变view的偏移位置，translationY=100，代表view在其原始位置向下移动100
                    //仔细观察进入的fragment中view从远处过来，不断向下移动，最终停在原始位置
                    ViewHelper.setTranslationY(view, (containerWidth - positionOffsetPixels) * tag.yIn);
                    ViewHelper.setTranslationX(view, (containerWidth - positionOffsetPixels) * tag.xIn);
                }
            }
        }
        if(outfragment!=null){
            List<View> outViews = outfragment.getParallaxViews();
            if(outViews!=null){
                for(View view:outViews){
                    ParallaxViewTag tag = (ParallaxViewTag) view.getTag(R.id.parallax_view_tag);
                    if (tag == null) {
                        continue;
                    }
                    //仔细观察退出的fragment中view从原始位置开始向上移动，translationY应为负数
                    ViewHelper.setTranslationY(view, 0 - positionOffsetPixels * tag.yOut);
                    ViewHelper.setTranslationX(view, 0 - positionOffsetPixels * tag.xOut);

                }
            }
        }


    }

    @Override
    public void onPageSelected(int position) {
        if(position==adapter.getCount()-1){
            iv_man.setVisibility(INVISIBLE);

        }else {
            iv_man.setVisibility(VISIBLE);
        }






    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //页面切换时，动画的控制
        AnimationDrawable animation = (AnimationDrawable) iv_man.getBackground();
        switch (state) {
            case ViewPager.SCROLL_STATE_DRAGGING:
                animation.start();
                break;

            case ViewPager.SCROLL_STATE_IDLE:
                animation.stop();
                break;

            default:
                break;
        }

    }
    //设置图片
    public void setIv_man(ImageView iv_man) {
        this.iv_man = iv_man;
    }








}
