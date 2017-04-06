package com.example.administrator.news.fragment;

import android.view.View;

import com.example.administrator.news.R;
import com.example.administrator.news.base.BaseFragment;

/**
 * Created by Administrator on 2017/4/6.
 */

public class ContentFragment extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.content_fragment,null);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}