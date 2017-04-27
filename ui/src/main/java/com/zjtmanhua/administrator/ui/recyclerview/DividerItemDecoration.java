package com.zjtmanhua.administrator.ui.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/**
 * rc的条目分割线
 * linearLayout,垂直方向和水平方向的间隔线画法
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private int mOriention = LinearLayoutManager.VERTICAL;
    private int[] attrs = new int[]{
            android.R.attr.listDivider
    };
    private Drawable mDivider;


    public void setOrientation(int orientation) {
        if (orientation != LinearLayoutManager.HORIZONTAL && orientation != LinearLayoutManager.VERTICAL) {
            throw new IllegalArgumentException("请设置方向");
        }
        this.mOriention = orientation;


    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //rc会回调绘制方法，需要自己去绘制分割线
        if (mOriention == LinearLayoutManager.VERTICAL) {//垂直
            drawVertical(c, parent);
        } else {//水平
            drawHorizontal(c, parent);
        }


        super.onDraw(c, parent, state);
    }

    /**
     * 横向方向间隔线
     *
     * @param c
     * @param parent
     */
    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin + Math.round(ViewCompat.getTranslationX(child));
            int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }


    }

    /**
     * 垂直方向绘制间隔线
     *
     * @param c
     * @param parent
     */
    private void drawVertical(Canvas c, RecyclerView parent) {
        //画水平线
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        //据子view绘制所有的间隔线
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin + Math.round(ViewCompat.getTranslationY(child));
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);


        }


    }

    public DividerItemDecoration(Context context, int mOriention) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs);
        mDivider = typedArray.getDrawable(0);
        typedArray.recycle();
        setOrientation(mOriention);

    }

    /**
     * 如果你需要访问额外的数据适配器,您可以调用
     *
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //获得条目的偏移量
        super.getItemOffsets(outRect, view, parent, state);
//        1.调用此方法首先获取条目间隙（outRect矩形区域）
//        2.获取条目的偏移量（所有条目都会调用一次该方法）左上右下（偏移值）
        if (mOriention == LinearLayoutManager.VERTICAL) {//垂直方向
//                outRect.set(0,0,0,"图片的高度");
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
//                outRect.set(0,0,图片的宽度,0);
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }


    }
}
