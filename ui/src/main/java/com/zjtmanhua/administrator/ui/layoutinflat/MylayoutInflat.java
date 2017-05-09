package com.zjtmanhua.administrator.ui.layoutinflat;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zjtmanhua.administrator.ui.R;

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
        super(inflater,context);
        this.fragment=fragment;
        //设置factroy
        setFactory(new ParallaxFactory(this));
    }




    @Override
    public LayoutInflater cloneInContext(Context newContext) {
        return new MylayoutInflat(this,newContext,fragment);
    }

    @Override
    public View inflate(XmlPullParser parser,  ViewGroup root) {
        return super.inflate(parser, root);
    }


    /**
     * 自定义layoutinfalter工厂
     */
    private class ParallaxFactory implements LayoutInflater.Factory{
        public  final int[] index={0,1,2,3,4,5
        };
        private LayoutInflater inflater;
        /**
         * 获取系统属性
         */
        private final String[] sClassPrefix = {
                "android.widget.",
                "android.view."
        };

        public ParallaxFactory(LayoutInflater inflater) {
            this.inflater=inflater;
        }

        /**
         * 自定义试图创建过程
         * @param name
         * @param context
         * @param attrs
         * @return
         */

        @Override
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            View view=null;
            if(view==null){
                view=createViewOrFailQuietly(name,context,attrs);
            }
            //实例化完成
            if(view !=null){
                setViewTag(view,context,attrs);
                fragment.getParallaxViews().add(view);

            }

            return null;
        }


        /**
         * 获取自定义属性，通过标签设置到视图上
         */
        private void setViewTag(View view, Context context, AttributeSet attrs) {
            //所有的自定义属性
            int[] attrIds = {
                    R.attr.a_in,
                    R.attr.a_out,
                    R.attr.x_in,
                    R.attr.x_out,
                    R.attr.y_in,
                    R.attr.y_out};
            //获取
            TypedArray a=context.obtainStyledAttributes(attrs,attrIds);
            if(a!=null&&a.length()>0){
                //获取自定义属性的值
                ParallaxViewTag tag=new ParallaxViewTag();
                tag.alphaIn = a.getFloat(index[0], 0f);
                tag.alphaOut = a.getFloat(index[1], 0f);
                tag.xIn = a.getFloat(index[2], 0f);
                tag.xOut = a.getFloat(index[3], 0f);
                tag.yIn = a.getFloat(index[4], 0f);
                tag.yOut = a.getFloat(index[5], 0f);
                //index
                view.setTag(R.id.parallax_view_tag,tag);

            }
            a.recycle();
        }

        /**
         * 判断是否是系统视图
         * @param name
         * @param context
         * @param attrs
         * @return
         */
        private View createViewOrFailQuietly(String name, Context context, AttributeSet attrs) {
            //自定义控件标签名称带.，创建的时候不需要加系统前缀
            if(name.contains(".")){
                createViewOrFailQuietly(name,null,context,attrs);
            }
            for (String prefix:sClassPrefix){
                View view=createViewOrFailQuietly(name,prefix,context,attrs);
                if(view!=null){
                    return view;
                }
            }
            return null;

        }

        /**
         * 创建视图
         * @param name
         * @param prefix
         * @param context
         * @param attrs
         * @return
         */
        private View createViewOrFailQuietly(String name,  String prefix, Context context, AttributeSet attrs) {

        try {
            //通过系统的inflater创建视图，读取系统的属性
            return inflater.createView(name,prefix,attrs);
        }catch (Exception e){
            return null;
            }


        }


    }
}
