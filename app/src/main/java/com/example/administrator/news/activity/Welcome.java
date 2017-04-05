package com.example.administrator.news.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.news.R;
import com.example.administrator.news.utils.CacheUtils;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler.sendEmptyMessageDelayed(0,3000);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            getHome();
            finish();
        }
    };

    public void getHome() {
        boolean isStartMain = CacheUtils.getBoolean(Welcome.this,"start_main");
        Intent intent;
        if (isStartMain){
            intent = new Intent(Welcome.this,MainActivity.class);
        }else{
            intent = new Intent(Welcome.this,GuideActivity.class);
        }
        startActivity(intent);
    }
}
