package com.example.administrator.news.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/4/6.
 */

public abstract class BaseFragment extends Fragment {

    public Context context;

    //当frament被创建的时候回调
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    //当视图被创建的时候回调
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    //让子类实现自己的视图
    public abstract View initView();

    //当Activitvy被创建之后回调
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    //如果子页页面没有数据，联网请求数据，并且绑定到initView初始化视图上
    public void initData() {
    }
}
