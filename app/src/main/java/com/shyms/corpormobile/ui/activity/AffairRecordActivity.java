package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;
import com.shyms.corpormobile.ui.adapter.AffairRecordAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AffairRecordActivity extends BaseActivity {
    @Bind(R.id.lv_affair_record_list)
    protected ListView mListView;
    @Bind(R.id.top_bar_back)
    protected FrameLayout mbarBack;
    @Bind(R.id.top_bar_title)
    protected TextView mTitle;

    private AffairRecordAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affair_record);
        ButterKnife.bind(this);

        mbarBack.setVisibility(View.VISIBLE);
        mTitle.setText("办事记录");
        mAdapter = new AffairRecordAdapter(this);
        mListView.setAdapter(mAdapter);
    }


}
