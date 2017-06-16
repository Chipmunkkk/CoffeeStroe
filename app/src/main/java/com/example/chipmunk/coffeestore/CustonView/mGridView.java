package com.example.chipmunk.coffeestore.CustonView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Chipmunk on 2017/6/3.
 */

public class mGridView extends GridView {
    public mGridView(Context context) {
        super(context);
    }

    public mGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public mGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO 自动生成的方法存根
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
