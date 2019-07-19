package com.bwie.searchview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.searchview.R;

import java.util.List;

public class SearchView extends LinearLayout {
    private EditText editText;
    private FlowLayout flowLayout;

    public SearchView(Context context) {
        this(context,null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SearchView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs){
        initLayout(context);//组合控件的布局
        initAttrs(context,attrs);//加载自定义属性


    }

    private void initLayout(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_layout,this,true);
//        addView(view);
        editText = findViewById(R.id.keyword);
        flowLayout = findViewById(R.id.flowlayout);
    }

    public void addTextView(Context context,String tv){
        TextView textView = new TextView(context);
        textView.setPadding(10,10,10,10);

        textView.setBackgroundColor(ContextCompat.getColor(context,R.color.colorPrimary));
        textView.setText(tv);
        flowLayout.addView(textView);
    }
    private void initAttrs(Context context,AttributeSet attrs) {

        // 获取属性集合 TypedArray
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SearchView);

        // 获取颜色的
        int color  = typedArray.getColor(R.styleable.SearchView_keywordColor, ContextCompat.getColor(context,R.color.colorPrimary));
        // 获取大小
        float size = typedArray.getDimension(R.styleable.SearchView_searchKeywordSize,15);//15的单位是什么？px

        typedArray.recycle();//回收
        editText.setTextColor(color);
        editText.setTextSize(size);






    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     * @param context
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public FlowLayout getFlowLayout() {
        return flowLayout;
    }
}
