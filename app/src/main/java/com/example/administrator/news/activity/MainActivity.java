package com.example.administrator.news.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.news.R;
import com.example.administrator.news.fragment.ContentFragment;
import com.example.administrator.news.fragment.leftmenuFragment;
import com.example.administrator.news.utils.DensityUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    public static final String LEFT_MENU_TAG = "left_menu_tag";
    public static final String MAIN_CONTENT_TAG = "main_content_tag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSlidingMenu();


        //初始化Fragment
        initFragment();
    }

    private void initSlidingMenu() {
        //设置左侧菜单
        setBehindContentView(R.layout.activity_leftmenu);

        //设置右侧菜单
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setSecondaryMenu(R.layout.rightmenu);

        //设置显示模式：左侧+主页，左侧+主页+右侧，主页+右侧
        slidingMenu.setMode(SlidingMenu.LEFT);

        //设置滑动模式：边缘滑动，全屏滑动，不可滑动
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        //设置主页占据的宽度
        slidingMenu.setBehindOffset(DensityUtil.dip2px(MainActivity.this, 200));
    }

    private void initFragment() {
        //得到FramentManger
        FragmentManager fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction ft = fm.beginTransaction();
        //替换
        ft.replace(R.id.activity_main, new ContentFragment(), MAIN_CONTENT_TAG);
        ft.replace(R.id.left_menu, new leftmenuFragment(), LEFT_MENU_TAG);
        ft.commit();
    }
}