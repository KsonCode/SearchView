package com.bwie.searchview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //第一步获取模式和大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        //测量所有的子view
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        int width = 0;
        int height = 0;


        //具体逻辑：
        if (heightMode==MeasureSpec.AT_MOST){//至多模式，wrap_content

            int childHeight = 0;
            for (int i = 0; i < getChildCount(); i++) {//获取所有子view

                View childView = getChildAt(i);//
                childHeight = childView.getMeasuredHeight();
                if (width+childView.getMeasuredWidth()>widthSize){//折行
                    width = 0;
                    height += childView.getMeasuredHeight();
                }
                width +=childView.getMeasuredWidth();
            }
            height+=childHeight;

        }

        //第三步，把最终的宽高给这个view
        setMeasuredDimension(widthSize,height);




    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int left = 0;
        int top = 0;

        if (getChildCount()>0){
            for (int i = 0; i < getChildCount(); i++) {

                //子view
                View childView = getChildAt(i);
                //
                if (left+childView.getMeasuredWidth()>getWidth()){
                    left = 0;
                    top+=childView.getMeasuredHeight();
                }

               childView.layout(left+10,top+10,left+childView.getMeasuredWidth(),top+childView.getMeasuredHeight());
                left +=childView.getMeasuredWidth();

            }
        }

    }

    /**
     * 这个方法不需要重写
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
