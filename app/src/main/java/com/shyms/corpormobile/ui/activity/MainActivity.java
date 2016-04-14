package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;
import com.shyms.corpormobile.ui.fragment.AffairGuideFragment;
import com.shyms.corpormobile.ui.fragment.HomePageFragment;
import com.shyms.corpormobile.ui.fragment.MyFragment;
import com.shyms.corpormobile.ui.fragment.SettingFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//TODO
public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Bind({R.id.btn1, R.id.btn2, R.id.btn4, R.id.btn5})
    protected ImageView mTabBtns[];
    private Fragment[] mFragments = {new HomePageFragment(), new AffairGuideFragment(), new MyFragment(), new SettingFragment()};

    private static final int TAB_ICONS[][] = {
            {R.drawable.nav_home, R.drawable.nav_ad,
                    R.drawable.nav_charity, R.drawable.nav_user},
            {R.drawable.nav_home_on, R.drawable.nav_ad_on,
                    R.drawable.nav_charity_on, R.drawable.nav_user_on}
    };

    private int mCurrentPageIdx = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setCurrentPage(0);

    }

    @Override
    @OnClick({R.id.party1, R.id.party2, R.id.party3, R.id.party4})
    public void onClick(View view) {

        int newPageIdx = mCurrentPageIdx;
        boolean isToRefresh = true;

        switch (view.getId()) {
            case R.id.party1:
                newPageIdx = 0;
                break;

            case R.id.party2:
                newPageIdx = 1;
                break;

            case R.id.party3:
                newPageIdx = 2;
                break;
            case R.id.party4:
                newPageIdx = 3;
                break;

        }
        setCurrentPage(newPageIdx);
    }


    private void setCurrentPage(int currentItem) {
        if (mCurrentPageIdx != currentItem) {
            for (int i = 0; i < mTabBtns.length; i++) {
                mTabBtns[i].setImageResource(TAB_ICONS[currentItem == i ? 1 : 0][i]);
            }
        }
        String tag = mFragments[currentItem].getClass().getSimpleName();
        FragmentManager manager = getSupportFragmentManager();
        if (manager.findFragmentByTag(tag) == null) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.container_main_page,
                    mFragments[currentItem], mFragments[currentItem].getClass().getSimpleName());
            transaction.commitAllowingStateLoss();
        }
        mCurrentPageIdx = currentItem;
    }


}
