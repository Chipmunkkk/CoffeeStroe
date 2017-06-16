package com.example.chipmunk.coffeestore.Home;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import com.example.chipmunk.coffeestore.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends Fragment implements View.OnClickListener {

    private Intent intent;

    private LinearLayout storeList;
    private GridView gridView_recommand;
    private List recommandCoffeeData;

    private RollPagerView rollPagerView;

    private View view;

    public HomePage(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home,container, false);
        return view;
    }

    private class rollViewpagerAdapter extends StaticPagerAdapter {

        private int[] res = {R.drawable.banner_1
                , R.drawable.banner_2,
                R.drawable.banner_1,
                R.drawable.banner_2};

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView imageView = new ImageView(container.getContext());
            imageView.setImageResource(res[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            return imageView;
        }

        @Override
        public int getCount() {
            return res.length;
        }
    }

    private void rollPagerViewSet() {
        rollPagerView.setPlayDelay(3000);//*播放间隔
        rollPagerView.setAnimationDurtion(500);//透明度
        rollPagerView.setAdapter(new rollViewpagerAdapter());//配置适配器
        rollPagerView.setHintView(new ColorPointHintView(getContext(), Color.argb(255, 213, 144, 104), Color.WHITE));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setOnClickListener();

        rollPagerView = (RollPagerView) view.findViewById(R.id.rollViewpager);
        rollPagerViewSet();

        recommandCoffeeData = new ArrayList();
        Map map = new HashMap();
        map.put("name","雀巢");
        map.put("price","¥20");
        recommandCoffeeData.add(map);
        recommandCoffeeData.add(map);
        recommandCoffeeData.add(map);
        recommandCoffeeData.add(map);

        String[] from = {"name","price"};
        int[] to = {R.id.id_recommand_name,R.id.id_recommand_price};

        SimpleAdapter recommandCoffee = new SimpleAdapter(getContext(),recommandCoffeeData,R.layout.gridview_item,from,to);
        gridView_recommand.setAdapter(recommandCoffee);
    }

    //初始化控件
    private void initView(){
        storeList = (LinearLayout) view.findViewById(R.id.module_1);
        gridView_recommand = (GridView) view.findViewById(R.id.id_recommand_view);
    }

    private void setOnClickListener(){
        storeList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.module_1://店铺列表
                intent = new Intent(getActivity(),StoreList.class);
                break;
        }
        startActivity(intent);
    }

}
