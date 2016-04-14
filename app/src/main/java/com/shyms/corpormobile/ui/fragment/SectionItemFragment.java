package com.shyms.corpormobile.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseFragment;
import com.shyms.corpormobile.ui.activity.AffairDetailActivity;
import com.shyms.corpormobile.ui.adapter.SectionDetailApapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Weimin on 4/11/2016.
 */
public class SectionItemFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @Bind(R.id.lv_list_detail)
    protected ListView mListView;
    private List<String> mTitle = new ArrayList<String>();
    //    protected String[] mTitle = {"部门内办理事件名称描述**********"};
    private SectionDetailApapter mApapter;

    @Override
    protected int getLayoutResID() {

        mTitle.add("部门内办理事件名称描述**********2016");
        return R.layout.fragment_item;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mApapter = new SectionDetailApapter(mContext);
        mApapter.appendDataList(mTitle);
        mListView.setAdapter(mApapter);

        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        startActivity(new Intent(mActivity, AffairDetailActivity.class));

    }
}
