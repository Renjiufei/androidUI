package com.zjtmanhua.administrator.ui.layoutinflat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 * 容器
 */

public class ParallaxContainer extends FrameLayout {

    private List<ParallaxFragment> fragments;

    public ParallaxContainer(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public void setup(){
        ViewPager viewPager=new ViewPager(getContext());




    }
}
