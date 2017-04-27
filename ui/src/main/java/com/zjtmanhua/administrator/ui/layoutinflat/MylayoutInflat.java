package com.zjtmanhua.administrator.ui.layoutinflat;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Administrator on 2017/4/26.
 * 自定义layoutInflate(解析xml 布局，做视差动画)
 *
 */

public class MylayoutInflat extends LayoutInflater {
    private ParallaxFragment fragment;
    //通过构造方法将需要的参数，传递进来
    protected MylayoutInflat(LayoutInflater inflater,Context context,ParallaxFragment fragment) {
        super(context);
        this.fragment=fragment;
        //设置factroy
    }




    @Override
    public LayoutInflater cloneInContext(Context newContext) {
        return null;
    }

    @Override
    public View inflate(XmlPullParser parser, @Nullable ViewGroup root) {
        return super.inflate(parser, root);
    }


    private class ParallaxFactory implements LayoutInflater.Factory{

        @Override
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            return null;
        }
    }
}
