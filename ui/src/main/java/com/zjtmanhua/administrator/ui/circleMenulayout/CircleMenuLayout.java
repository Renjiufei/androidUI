//package com.zjtmanhua.administrator.ui.circleMenulayout;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.util.DisplayMetrics;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.WindowManager;
//
//import com.zjtmanhua.administrator.ui.R;
//
///**
// * Created by Administrator on 2017/4/24.
// * 圆形菜单的学习，主要运用adapter模式实现
// * 练习自定义控件
// */
//
//public class CircleMenuLayout extends ViewGroup {
//    private int mRadius;
//    /**
//     * 该容器内child item的默认尺寸
//     */
//    private static final float RADIO_DEFAULT_CHILD_DIMENSION = 1 / 4f;
//    /**
//     * 菜单的中心child的默认尺寸
//     */
//    private float RADIO_DEFAULT_CENTERITEM_DIMENSION = 1 / 3f;
//    /**
//     * 该容器的内边距,无视padding属性，如需边距请用该变量
//     */
//    private static final float RADIO_PADDING_LAYOUT = 1 / 12f;
//
//    /**
//     * 当每秒移动角度达到该值时，认为是快速移动
//     */
//    private static final int FLINGABLE_VALUE = 300;
//
//    /**
//     * 如果移动角度达到该值，则屏蔽点击
//     */
//    private static final int NOCLICK_VALUE = 3;
//
//    /**
//     * 当每秒移动角度达到该值时，认为是快速移动
//     */
//    private int mFlingableValue = FLINGABLE_VALUE;
//    /**
//     * 该容器的内边距,无视padding属性，如需边距请用该变量
//     */
//    private float mPadding;
//    /**
//     * 布局时的开始角度
//     */
//    private double mStartAngle = 0;
//    /**
//     * 菜单项的文本
//     */
//    private String[] mItemTexts;
//    /**
//     * 菜单项的图标
//     */
//    private int[] mItemImgs;
//
//    /**
//     * 菜单的个数
//     */
//    private int mMenuItemCount;
//
//    /**
//     * 检测按下到抬起时旋转的角度
//     */
//    private float mTmpAngle;
//    /**
//     * 检测按下到抬起时使用的时间
//     */
//    private long mDownTime;
//
//    /**
//     * 判断是否正在自动滚动
//     */
//    private boolean isFling;
//
//    private int mMenuItemLayoutId = R.layout.circle_menu_item;
//
//
//
//
//
//    public CircleMenuLayout(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        setPadding(0, 0, 0, 0);
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int resWidth = 0;
//        int resHeight = 0;
//
//        /**
//         * 根据传入的参数，分别获取测量模式和测量值
//         */
//        int width = MeasureSpec.getSize(widthMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//
//        int height = MeasureSpec.getSize(heightMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
///**
// * 如果宽或者高的测量模式非精确值
// */
//        if (widthMode != MeasureSpec.EXACTLY
//                || heightMode != MeasureSpec.EXACTLY)
//        {
//            // 主要设置为背景图的高度
//            resWidth = getSuggestedMinimumWidth();
//            // 如果未设置背景图片，则设置为屏幕宽高的默认值
//            resWidth = resWidth == 0 ? getDefaultWidth() : resWidth;
//
//            resHeight = getSuggestedMinimumHeight();
//            // 如果未设置背景图片，则设置为屏幕宽高的默认值
//            resHeight = resHeight == 0 ? getDefaultWidth() : resHeight;
//        } else
//        {
//            // 如果都设置为精确值，则直接取小值；
//            resWidth = resHeight = Math.min(width, height);
//        }
//        setMeasuredDimension(resWidth, resHeight);
//
//        // 获得半径
//        mRadius = Math.max(getMeasuredWidth(), getMeasuredHeight());
//
//        // menu item数量
//        final int count = getChildCount();
//        // menu item尺寸
//        int childSize = (int) (mRadius * RADIO_DEFAULT_CHILD_DIMENSION);
//        // menu item测量模式
//        int childMode = MeasureSpec.EXACTLY;
//
//        // 迭代测量
//        for (int i = 0; i < count; i++)
//        {
//            final View child = getChildAt(i);
//
//            if (child.getVisibility() == GONE)
//            {
//                continue;
//            }
//
//            // 计算menu item的尺寸；以及和设置好的模式，去对item进行测量
//            int makeMeasureSpec = -1;
//
////            if (child.getId() == R.id.id_circle_menu_item_center)
////            {
////                makeMeasureSpec = MeasureSpec.makeMeasureSpec(
////                        (int) (mRadius * RADIO_DEFAULT_CENTERITEM_DIMENSION),
////                        childMode);
////            } else
////            {
////                makeMeasureSpec = MeasureSpec.makeMeasureSpec(childSize,
////                        childMode);
////            }
//            child.measure(makeMeasureSpec, makeMeasureSpec);
//        }
//
//        mPadding = RADIO_PADDING_LAYOUT * mRadius;
//
//
//
//
//
//
//    }
//
//    /**
//     * 获得默认该layout的尺寸
//     *
//     * @return
//     */
//    private int getDefaultWidth()
//    {
//        WindowManager wm = (WindowManager) getContext().getSystemService(
//                Context.WINDOW_SERVICE);
//        DisplayMetrics outMetrics = new DisplayMetrics();
//        wm.getDefaultDisplay().getMetrics(outMetrics);
//        return Math.min(outMetrics.widthPixels, outMetrics.heightPixels);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//
//    }
//
//    /**
//     * MenuItem的点击事件接口
//     *
//     * @author zhy
//     *
//     */
//    public interface OnMenuItemClickListener
//    {
//        void itemClick(View view, int pos);
//
//        void itemCenterClick(View view);
//    }
//
//    /**
//     * MenuItem的点击事件接口
//     */
//    private OnMenuItemClickListener mOnMenuItemClickListener;
//
//    /**
//     * 设置MenuItem的点击事件接口
//     *
//     * @param mOnMenuItemClickListener
//     */
//    public void setOnMenuItemClickListener(
//            OnMenuItemClickListener mOnMenuItemClickListener)
//    {
//        this.mOnMenuItemClickListener = mOnMenuItemClickListener;
//    }
//
//
//
//}
