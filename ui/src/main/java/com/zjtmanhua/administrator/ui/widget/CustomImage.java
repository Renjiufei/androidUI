package com.zjtmanhua.administrator.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * 为了使用自定属性，自定义一个系统控件
 */

public class CustomImage extends android.support.v7.widget.AppCompatImageView {
    public CustomImage(Context context) {
        super(context);
    }

    public CustomImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
