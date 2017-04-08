package com.example.administrator.news.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.example.administrator.news.base.BasePager;

/**
 * Created by Administrator on 2017/4/8.
 */

public class aaaaaaaaaaa extends BasePager {
    public aaaaaaaaaaa(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        tv_title.setText("主页面");

        TextView textView = new TextView(context);
        textView.setText("主页面内容");
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);

        
    }
}
