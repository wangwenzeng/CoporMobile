package com.shyms.corpormobile.ui.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shyms.corpormobile.R;
import com.shyms.corpormobile.ui.fragment.NewsDetailFragment;

/**
 * Created by Weimin on 4/11/2016.
 */
public class MyPageAdapter extends PagerAdapter {

    private FragmentManager fm;
    private Activity mActivity;
    private ViewPager mViewPager;

    public MyPageAdapter(FragmentManager fm, Activity activity, ViewPager viewPager) {
        super();
        mActivity = activity;
        mViewPager = viewPager;
        this.fm = fm;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (mActivity == null) {
            return null;
        }
        LayoutInflater mInflater = mActivity.getLayoutInflater();

        View view = mInflater.inflate(R.layout.item_page_auto, mViewPager, false);

        SimpleDraweeView mBrief = (SimpleDraweeView) view.findViewById(R.id.fresco_brief);
//mBrief.setImageURI("");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {

                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.container_main_page, new NewsDetailFragment());
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        // 1. 将要显示的View加到ViewPager里
        container.addView(view);
        // 2. 将对象返回给框架, 缓存一些数据// 必须重写此方法, 否则报错
        container.addView(view);
        return view;
    }

    //销毁条目
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 1;
    }

    //复用对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}