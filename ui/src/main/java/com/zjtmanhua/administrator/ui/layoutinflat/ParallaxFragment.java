package com.zjtmanhua.administrator.ui.layoutinflat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */

public class ParallaxFragment extends Fragment {
    //此Fragment上所有的需要实现视差动画的视图
    private List<View> parallaxViews = new ArrayList<View>();

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //获取bundle
        Bundle args=getArguments();
        int layoutId=args.getInt("layoutId");
        int index=args.getInt("index");
        Log.d("jason", "fragment:"+index);
        //1.布局加载器将布局加载进来了
        //2.解析创建布局上所有的视图
        //3.自己搞定创建视图的过程
        //4.获取视图相关的自定义属性的值
        //5.通过设置布局做一个视差属性动画
//        MylayoutInflat inflater=new MylayoutInflat(inflater,getActivity(),this);






        return inflater.inflate(layoutId, null);
    }
    public List<View> getParallaxViews() {
        return parallaxViews;
    }
}
