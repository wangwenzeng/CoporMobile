package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.ui.fragment.SectionItemFragment;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BranchActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.pager)
    protected ViewPager mViewPage;
    @Bind(R.id.indicator)
    TabPageIndicator indicator;
    @Bind(R.id.UpIndicator)
    UnderlinePageIndicator underlinePageIndicator;
    private String[] TITLE = {"经促局", "工商局", "民政局"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        ButterKnife.bind(this);

        mViewPage.setAdapter(new TabPageIndicatorAdapter(getSupportFragmentManager()));
//        mPagerTabStrip.setTabIndicatorColor(Color.parseColor("#FF0000"));
        indicator.setViewPager(mViewPage);
        underlinePageIndicator.setViewPager(mViewPage);
        indicator.setOnPageChangeListener(underlinePageIndicator);
        underlinePageIndicator.setOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class TabPageIndicatorAdapter extends FragmentPagerAdapter {
        public TabPageIndicatorAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public Fragment getItem(int position) {
            return new SectionItemFragment();
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

}
