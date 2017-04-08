package com.example.administrator.news.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.example.administrator.news.R;
import com.example.administrator.news.activity.MainActivity;
import com.example.administrator.news.base.BaseFragment;
import com.example.administrator.news.base.BasePager;
import com.example.administrator.news.pager.HomePager;
import com.example.administrator.news.pager.NewsCenterPager;
import com.example.administrator.news.pager.SettingPager;
import com.example.administrator.news.pager.aaaaaaaaaaa;
import com.example.administrator.news.pager.bbbbbb;
import com.example.administrator.news.view.NoScrollViewPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/6.
 */

public class ContentFragment extends BaseFragment {

    @ViewInject(R.id.rg_main)
    private RadioGroup rg_main;

    @ViewInject(R.id.viewpager)
    private NoScrollViewPager viewPager;

    @ViewInject(R.id.ib_menu)
    private ImageButton ib_menu;

    //5个viewPager页面的集合
    private ArrayList<BasePager> basePagers;
    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.content_fragment,null);
        x.view().inject(ContentFragment.this,view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        basePagers = new ArrayList<>();
        basePagers.add(new HomePager(context));
        basePagers.add(new NewsCenterPager(context));
        basePagers.add(new aaaaaaaaaaa(context));
        basePagers.add(new bbbbbb(context));
        basePagers.add(new SettingPager(context));

        viewPager.setAdapter(new ContentFragmentAdapter());

        //设置RadioGroup的选中状态改变的监听
        rg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());

        //监听某个页面被选中,初始对应的页面的数据
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
        basePagers.get(0).initData();
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //当某个页面被选中的时候回调这个方法
        @Override
        public void onPageSelected(int position) {
            /*BasePager basePager = basePagers.get(position);
            basePager.initData();*/
            //调用被选中的页面的initData方法
            basePagers.get(position).initData();
            
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_home:
                    viewPager.setCurrentItem(0,false);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_FULLSCREEN);

                    break;
                case R.id.rb_news:
                    viewPager.setCurrentItem(1,false);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
                case R.id.rb_smartservice:
                    viewPager.setCurrentItem(2,false);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
                case R.id.rb_govaffair:
                    viewPager.setCurrentItem(3,false);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
                case R.id.rb_setting:
                    viewPager.setCurrentItem(4,false);
                    isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
                    break;
            }
        }
    }

    //设置SlidingMenu是否可以滑动
    private void isEnableSlidingMenu(int touchmodeFullscreen) {
        MainActivity mainActivity = (MainActivity) context;
        mainActivity.getSlidingMenu().setTouchModeAbove(touchmodeFullscreen);
    }

    class ContentFragmentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {

            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager basePager = basePagers.get(position);
            View rootView = basePager.rootView;
            basePager.initData();
            container.addView(rootView);
            return rootView;
        }
    }
}