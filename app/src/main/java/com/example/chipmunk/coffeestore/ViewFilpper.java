package com.example.chipmunk.coffeestore;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class ViewFilpper extends Activity implements View.OnTouchListener{

    // 左右滑动时手指按下的X坐标
    private float touchDownX;
    // 左右滑动时手指松开的X坐标
    private float touchUpX;

    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_filpper);
        viewFlipper = (ViewFlipper) findViewById(R.id.id_viewFilpper_main);
        viewFlipper.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int count = viewFlipper.getChildCount();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // 取得左右滑动时手指按下的X坐标
            touchDownX = event.getX();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            // 取得左右滑动时手指松开的X坐标
            touchUpX = event.getX();
            // 从左往右，看前一个View
            if (touchUpX - touchDownX > 100) {
                // 设置View切换的动画
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                        android.R.anim.slide_in_left));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                        android.R.anim.slide_out_right));
                // 显示下一个View
                viewFlipper.showPrevious();
                // 从右往左，看后一个View
            } else if (touchDownX - touchUpX > 100) {
                // 设置View切换的动画
                // 由于Android没有提供slide_out_left和slide_in_right，所以仿照slide_in_left和slide_out_right编写了slide_out_left和slide_in_right
                viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.slide_in_right));
                viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                        R.anim.slide_out_left));
                // 显示前一个View
                viewFlipper.showNext();
                if(viewFlipper.getDisplayedChild() == 0){
                    Intent intent=new Intent();
                    intent.setClass(ViewFilpper.this, Login.class);
                    startActivity(intent);
                }
            }
            return true;
        }
        return false;
    }
}
