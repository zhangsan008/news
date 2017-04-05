package com.example.administrator.news.utils;

import android.content.Context;

/**
 * Created by Administrator on 2017/4/5.
 */

public class DensityUtil {
    //根据手机的分辨率从dip的单位转成px
    public static int dip2px(Context context,float dpValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //根据手机的分辨率从px转换成dip
    public static int px2dip(Context context,float pxValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
