package com.example.chipmunk.coffeestore.CustonView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.chipmunk.coffeestore.R;

/**
 * Created by Chipmunk on 2017/6/3.
 */

public class Title_Main extends LinearLayout {
    public Title_Main(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_main,this);
    }
}
