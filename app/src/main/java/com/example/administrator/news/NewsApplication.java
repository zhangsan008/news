package com.example.administrator.news;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2017/4/7.
 */

public class NewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.setDebug(true);
        x.Ext.init(this);
    }
}
