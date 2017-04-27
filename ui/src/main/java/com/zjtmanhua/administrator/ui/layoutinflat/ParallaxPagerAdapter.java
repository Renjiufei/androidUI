package com.zjtmanhua.administrator.ui.layoutinflat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 * viewpager的适配器
 */

public class ParallaxPagerAdapter extends FragmentPagerAdapter {
    //定义一个fragment集合
    private List<ParallaxFragment> parallaxFragments;
    public ParallaxPagerAdapter(FragmentManager fm,List<ParallaxFragment> parallaxFragments) {
        super(fm);
        this.parallaxFragments=parallaxFragments;
    }

    @Override
    public Fragment getItem(int position) {

        return parallaxFragments.get(position);
    }

    @Override
    public int getCount() {
        return parallaxFragments.size();
    }
}
