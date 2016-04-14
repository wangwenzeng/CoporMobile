package com.shyms.corpormobile.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseFragment;
import com.shyms.corpormobile.helper.GotoHelper;
import com.shyms.corpormobile.module.NInformationData;
import com.shyms.corpormobile.net.NetRequest;
import com.shyms.corpormobile.ui.activity.AffairRecordActivity;
import com.shyms.corpormobile.ui.activity.LineUpActivity;
import com.shyms.corpormobile.ui.activity.RemindActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Weimin on 4/9/2016.
 */
public class HomePageFragment extends BaseFragment {

    @Bind(R.id.top_bar_left_image)
    protected ImageView mTopBarBack;

    @Bind(R.id.vp_home_pic_auto)
    protected AutoScrollViewPager mViewPager;


    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_page_home;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTopBarBack.setVisibility(View.INVISIBLE);

        MyPageAdapter adapter = new MyPageAdapter();
        mViewPager.setAdapter(adapter);
//        mViewPager.startAutoScroll();
        getLatestData();
    }

    @OnClick(R.id.rl_home_party1)
    protected void onClickRecord() {
        startActivity(new Intent(mActivity, AffairRecordActivity.class));
    }

    @OnClick(R.id.rl_home_party3)
    protected void onClickLineUp() {
        startActivity(new Intent(mActivity, LineUpActivity.class));
    }

    @OnClick(R.id.rl_home_party4)
    protected void onClickRemind() {
        startActivity(new Intent(mActivity, RemindActivity.class));
    }


    public void getLatestData() {

//        NetRequest.APIInstance.get
        NetRequest.APIInstance.getInformation()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(results -> {
                }, throwable -> {
                });
    }

    public class MyPageAdapter extends PagerAdapter {

        List<NInformationData> mDataList;

        public void setDataList(List<NInformationData> dataList) {

            if (dataList != null) {
                mDataList = new ArrayList<>();
                mDataList = dataList;
            }
            notifyDataSetChanged();
        }

        public MyPageAdapter() {
            super();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (mActivity == null) {
                return null;
            }
            LayoutInflater mInflater = mActivity.getLayoutInflater();

            View view = mInflater.inflate(R.layout.item_page_auto, mViewPager, false);

            SimpleDraweeView mBrief = (SimpleDraweeView) view.findViewById(R.id.fresco_brief);

            //TODO 动态显示图片
//            if (mDataList != null) {
//                mBrief.setImageURI(Uri.parse(mDataList.get(position).brief));
//            }

            view.setOnClickListener(view1 -> {
//                Bundle bundle = null;
//                bundle.putSerializable("detail", mDataList.get(position));
                GotoHelper.gotoFragment(getFragmentManager(), new NewsDetailFragment());
            });


            // 1. 将要显示的View加到ViewPager里
            container.addView(view);
            // 2. 将对象返回给框架, 缓存一些数据// 必须重写此方法, 否则报错
//            container.addView(view);
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
}