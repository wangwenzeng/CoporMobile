package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;
import com.shyms.corpormobile.ui.adapter.AffairRemindAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RemindActivity extends BaseActivity {

    @Bind(R.id.top_bar_title)
    protected TextView mTitle;
    @Bind(R.id.top_bar_back)
    protected FrameLayout mbarBack;
    @Bind(R.id.iv_remind_list)
    protected ListView mListView;

    private AffairRemindAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind);
        ButterKnife.bind(this);
        mTitle.setText("提醒");
        mbarBack.setVisibility(View.VISIBLE);
        mAdapter = new AffairRemindAdapter(this);
        mListView.setAdapter(mAdapter);


    }

}
