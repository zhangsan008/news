package com.example.administrator.news.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/4/3.
 */

public class CacheUtils {
    public static boolean getBoolean(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences("access",Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences("access",context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }
}
