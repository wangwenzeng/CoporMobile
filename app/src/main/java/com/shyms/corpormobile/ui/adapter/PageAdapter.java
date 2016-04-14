package com.shyms.corpormobile.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Weimin on 4/12/2016.
 */
public class PageAdapter extends PagerAdapter {
    public List<View> mListViews;

    public PageAdapter(List<View> mListViews) {
        this.mListViews = mListViews;
    }

    @Override
    public void destroyItem(ViewGroup container, int pos, Object arg2) {
        container.removeView(mListViews.get(pos));
    }

    @Override
    public void finishUpdate(View arg0) {
    }

    @Override
    public int getCount() {
        return mListViews.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int pos) {
        container.addView(mListViews.get(pos), 0);
        return mListViews.get(pos);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == (arg1);
    }
}
