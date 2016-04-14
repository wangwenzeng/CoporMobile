package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;
import com.shyms.corpormobile.ui.fragment.AcceptProcessFragment;
import com.shyms.corpormobile.ui.fragment.AffairProcessFragment;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 办理流程  受理 预约等的activity
 */
public class AffairDetailActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.vp_affair_page)
    protected ViewPager mViewPage;
    @Bind(R.id.tab_indicator)
    TabPageIndicator mIndicator;
    @Bind(R.id.lp_Indicator)
    UnderlinePageIndicator mLPIndicator;

    private String[] TITLE = {"办理流程", "受理点"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affair_detail);
        ButterKnife.bind(this);
        mViewPage.setAdapter(new TabPageIndicatorAdapter(getSupportFragmentManager()));
//        mPagerTabStrip.setTabIndicatorColor(Color.parseColor("#FF0000"));
        mIndicator.setViewPager(mViewPage);
        mLPIndicator.setViewPager(mViewPage);
        mIndicator.setOnPageChangeListener(mLPIndicator);
        mLPIndicator.setOnPageChangeListener(this);
    }


    class TabPageIndicatorAdapter extends FragmentPagerAdapter {
        public TabPageIndicatorAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //新建一个Fragment来展示ViewPager item的内容，并传递参数
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new AffairProcessFragment();
                    break;
                case 1:
                    fragment = new AcceptProcessFragment();
                    break;
            }

            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position % TITLE.length];
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }
    }

    @Override
    public void onPageScrolled(int position, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int position) {

    }
}
