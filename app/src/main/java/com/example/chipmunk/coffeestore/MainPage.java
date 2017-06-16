package com.example.chipmunk.coffeestore;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SpinnerAdapter;

import com.example.chipmunk.coffeestore.Cart.CartPage;
import com.example.chipmunk.coffeestore.Home.HomePage;
import com.example.chipmunk.coffeestore.Me.MePage;
import com.example.chipmunk.coffeestore.Search.SearchPage;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends FragmentActivity implements View.OnClickListener {

    private HomePage HomePage;
    private CartPage CartPage;
    private SearchPage SearchPage;
    private MePage MePage;

    private RadioButton radio_Home;
    private RadioButton radio_Cart;
    private RadioButton radio_Search;
    private RadioButton radio_Me;

    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<Fragment> pageList;

    Drawable topDrawable_store_normal;
    Drawable topDrawable_cart_normal;
    Drawable topDrawable_search_normal;
    Drawable topDrawable_account_normal;
    Drawable topDrawable_store_selected;
    Drawable topDrawable_cart_selected;
    Drawable topDrawable_search_selected;
    Drawable topDrawable_account_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        ActionBar actionBar = new ActionBar() {
            @Override
            public void setCustomView(View view) {

            }

            @Override
            public void setCustomView(View view, LayoutParams layoutParams) {

            }

            @Override
            public void setCustomView(int i) {

            }

            @Override
            public void setIcon(@DrawableRes int i) {

            }

            @Override
            public void setIcon(Drawable drawable) {

            }

            @Override
            public void setLogo(@DrawableRes int i) {

            }

            @Override
            public void setLogo(Drawable drawable) {

            }

            @Override
            public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, OnNavigationListener onNavigationListener) {

            }

            @Override
            public void setSelectedNavigationItem(int i) {

            }

            @Override
            public int getSelectedNavigationIndex() {
                return 0;
            }

            @Override
            public int getNavigationItemCount() {
                return 0;
            }

            @Override
            public void setTitle(CharSequence charSequence) {

            }

            @Override
            public void setTitle(@StringRes int i) {

            }

            @Override
            public void setSubtitle(CharSequence charSequence) {

            }

            @Override
            public void setSubtitle(int i) {

            }

            @Override
            public void setDisplayOptions(int i) {

            }

            @Override
            public void setDisplayOptions(int i, int i1) {

            }

            @Override
            public void setDisplayUseLogoEnabled(boolean b) {

            }

            @Override
            public void setDisplayShowHomeEnabled(boolean b) {

            }

            @Override
            public void setDisplayHomeAsUpEnabled(boolean b) {

            }

            @Override
            public void setDisplayShowTitleEnabled(boolean b) {

            }

            @Override
            public void setDisplayShowCustomEnabled(boolean b) {

            }

            @Override
            public void setBackgroundDrawable(@Nullable Drawable drawable) {

            }

            @Override
            public View getCustomView() {
                return null;
            }

            @Nullable
            @Override
            public CharSequence getTitle() {
                return null;
            }

            @Nullable
            @Override
            public CharSequence getSubtitle() {
                return null;
            }

            @Override
            public int getNavigationMode() {
                return 0;
            }

            @Override
            public void setNavigationMode(int i) {

            }

            @Override
            public int getDisplayOptions() {
                return 0;
            }

            @Override
            public Tab newTab() {
                return null;
            }

            @Override
            public void addTab(Tab tab) {

            }

            @Override
            public void addTab(Tab tab, boolean b) {

            }

            @Override
            public void addTab(Tab tab, int i) {

            }

            @Override
            public void addTab(Tab tab, int i, boolean b) {

            }

            @Override
            public void removeTab(Tab tab) {

            }

            @Override
            public void removeTabAt(int i) {

            }

            @Override
            public void removeAllTabs() {

            }

            @Override
            public void selectTab(Tab tab) {

            }

            @Nullable
            @Override
            public Tab getSelectedTab() {
                return null;
            }

            @Override
            public Tab getTabAt(int i) {
                return null;
            }

            @Override
            public int getTabCount() {
                return 0;
            }

            @Override
            public int getHeight() {
                return 0;
            }

            @Override
            public void show() {

            }

            @Override
            public void hide() {

            }

            @Override
            public boolean isShowing() {
                return false;
            }

            @Override
            public void addOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {

            }

            @Override
            public void removeOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {

            }
        };
        actionBar.show();
        initView();
        SetOnClickListener();
        setImage_selected(0);
    }

    public void initView() {
        viewPager = (ViewPager) findViewById(R.id.id_viewPager_main);
        radio_Home = (RadioButton) findViewById(R.id.radio_home);
        radio_Cart = (RadioButton) findViewById(R.id.radio_cart);
        radio_Search = (RadioButton) findViewById(R.id.radio_search);
        radio_Me = (RadioButton) findViewById(R.id.radio_me);

        topDrawable_store_normal = getResources().getDrawable(R.drawable.store_normal);
        topDrawable_cart_normal = getResources().getDrawable(R.drawable.cart_normal);
        topDrawable_search_normal = getResources().getDrawable(R.drawable.search_normal);
        topDrawable_account_normal = getResources().getDrawable(R.drawable.account_normal);

        topDrawable_store_selected = getResources().getDrawable(R.drawable.store_selected);
        topDrawable_cart_selected = getResources().getDrawable(R.drawable.cart_selected);
        topDrawable_search_selected = getResources().getDrawable(R.drawable.search_selected);
        topDrawable_account_selected = getResources().getDrawable(R.drawable.account_selected);

        pageList = new ArrayList<Fragment>();

        HomePage = new HomePage();
        CartPage = new CartPage();
        SearchPage = new SearchPage();
        MePage = new MePage();

        pageList.add(HomePage);
        pageList.add(CartPage);
        pageList.add(SearchPage);
        pageList.add(MePage);

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return pageList.get(i);
            }

            @Override
            public int getCount() {
                return pageList.size();
            }
        };

        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                setPage(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public void SetOnClickListener() {
        radio_Home.setOnClickListener(this);
        radio_Cart.setOnClickListener(this);
        radio_Search.setOnClickListener(this);
        radio_Me.setOnClickListener(this);
    }

    public void setPage(int i) {
        setImage_normal();
        setImage_selected(i);
        viewPager.setCurrentItem(i);
    }

    public void setImage_normal() {
        topDrawable_store_normal.setBounds(0,0,topDrawable_store_normal.getMinimumWidth(),topDrawable_store_normal.getMinimumHeight());
        topDrawable_cart_normal.setBounds(0,0,topDrawable_cart_normal.getMinimumWidth(),topDrawable_cart_normal.getMinimumHeight());
        topDrawable_search_normal.setBounds(0,0,topDrawable_search_normal.getMinimumWidth(),topDrawable_search_normal.getMinimumHeight());
        topDrawable_account_normal.setBounds(0,0,topDrawable_account_normal.getMinimumWidth(),topDrawable_account_normal.getMinimumHeight());
        radio_Home.setCompoundDrawables(null, topDrawable_store_normal, null, null);
        radio_Cart.setCompoundDrawables(null, topDrawable_cart_normal, null, null);
        radio_Search.setCompoundDrawables(null, topDrawable_search_normal, null, null);
        radio_Me.setCompoundDrawables(null, topDrawable_account_normal, null, null);
    }

    public void setImage_selected(int i) {
        switch (i) {
            case 0:
                topDrawable_store_selected.setBounds(0,0,topDrawable_store_selected.getMinimumWidth(),topDrawable_store_selected.getMinimumHeight());
                radio_Home.setCompoundDrawables(null, topDrawable_store_selected, null, null);
                break;
            case 1:
                topDrawable_cart_selected.setBounds(0,0,topDrawable_cart_selected.getMinimumWidth(),topDrawable_cart_selected.getMinimumHeight());
                radio_Cart.setCompoundDrawables(null, topDrawable_cart_selected, null, null);
                break;
            case 2:
                topDrawable_search_selected.setBounds(0,0,topDrawable_search_selected.getMinimumWidth(),topDrawable_search_selected.getMinimumHeight());
                radio_Search.setCompoundDrawables(null, topDrawable_search_selected, null, null);
                break;
            case 3:
                topDrawable_account_selected.setBounds(0,0,topDrawable_account_selected.getMinimumWidth(),topDrawable_account_selected.getMinimumHeight());
                radio_Me.setCompoundDrawables(null, topDrawable_account_selected, null, null);
                break;
            default:break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radio_home:
                setPage(0);
                break;
            case R.id.radio_cart:
                setPage(1);
                break;
            case R.id.radio_search:
                setPage(2);
                break;
            case R.id.radio_me:
                setPage(3);
                break;
            default:
                break;
        }
    }
}
