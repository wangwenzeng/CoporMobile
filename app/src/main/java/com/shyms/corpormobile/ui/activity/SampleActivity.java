package com.shyms.corpormobile.ui.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseActivity;
import com.shyms.corpormobile.ui.adapter.SampleAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SampleActivity extends BaseActivity {

    @Bind(R.id.top_bar_title)
    protected TextView mTitle;
    @Bind(R.id.lv_material_list)
    protected ListView mlistView;
    private SampleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ButterKnife.bind(this);
        mTitle.setText("材料下载页面");

        mAdapter = new SampleAdapter(this);
        mlistView.setAdapter(mAdapter);

    }
}
