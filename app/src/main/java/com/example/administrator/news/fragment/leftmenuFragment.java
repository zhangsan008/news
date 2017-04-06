package com.example.administrator.news.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import com.example.administrator.news.base.BaseFragment;

/**
 * Created by Administrator on 2017/4/6.
 */

public class leftmenuFragment extends BaseFragment {

    private TextView textView;
    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextSize(23);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("左侧菜单页面");
    }
}
