package com.example.administrator.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.administrator.news.R;
import com.example.administrator.news.utils.CacheUtils;
import com.example.administrator.news.utils.DensityUtil;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private Button start_main;
    private LinearLayout point_group;
    private ArrayList<ImageView> imageViews;
    private ImageView img_red_point;
    private int leftMax;
    private int widthdip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        start_main = (Button) findViewById(R.id.start_main);
        point_group = (LinearLayout) findViewById(R.id.point_group);
        img_red_point = (ImageView) findViewById(R.id.img_red_point);

        int[] ids = {R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
        imageViews = new ArrayList<>();

        widthdip = DensityUtil.dip2px(this,10);
        for (int i = 0; i < ids.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            imageViews.add(imageView);

            //创建点
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_normal);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(widthdip,widthdip);
            if (i != 0){
                params.leftMargin = 10;
            }
            point.setLayoutParams(params);
            point_group.addView(point);
        }

        viewpager.setAdapter(new MyPagerAdapter());
        img_red_point.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**
             * 页面滚动回调这个方法
             * @param position  当前滑动页面的位置
             * @param positionOffset    页面滑动的百分比
             * @param positionOffsetPixels 滑动的像素
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //int leftMargin = (int) (positionOffset * leftMax);
                int leftMargin = (int) (position * leftMax + (positionOffset * leftMax));
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) img_red_point.getLayoutParams();
                params.leftMargin = leftMargin;
                img_red_point.setLayoutParams(params);
            }

            /**
             * 当页面被选中的时候,回调这个方法
             * @param position 被选中页面的对应的位置
             */
            @Override
            public void onPageSelected(int position) {
                if(position == imageViews.size()-1){
                    //最后一个引导页面显示"开始体验"
                    start_main.setVisibility(View.VISIBLE);
                }else{
                    //非最后一个引导页面不显示"开始体验"
                    start_main.setVisibility(View.GONE);
                }
            }

            /**
             * 当viewpage页面滑动状态发生变化的时候
             * @param state
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        start_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.记录曾经进入过主页面
                CacheUtils.putBoolean(GuideActivity.this,"start_main",true);
                //2.跳转到主页面
                Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
                //3.关闭引导页面
                finish();
            }
        });
    }

    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener{

        @Override
        public void onGlobalLayout() {
            img_red_point.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            leftMax = point_group.getChildAt(1).getLeft() - point_group.getChildAt(0).getLeft();

        }
    }

    class MyPagerAdapter extends PagerAdapter {

        /**
         * 返回数据的总个数
         *
         * @return
         */
        @Override
        public int getCount() {
            return imageViews.size();
        }

        /**
         * 判断
         * @param view 当前创建的视图
         * @param object instantiateItem返回的结果值
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            //return view == imageViews.get(Integer.parseInt((String) object));
            return view == object;
        }

        /**
         *
         * @param container ViewPager
         * @param position  要销毁页面的位置
         * @param object    要销毁页面
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        /**
         *作用,getView
         * @param container ViewPage
         * @param position  要创建页面的位置
         * @return 返回和创建当前页面有关系的值
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imageViews.get(position);
            container.addView(imageView);
            //return position;
            return imageView;
        }
    }
}
