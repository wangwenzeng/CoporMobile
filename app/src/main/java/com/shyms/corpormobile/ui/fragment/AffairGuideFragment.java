package com.shyms.corpormobile.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseFragment;
import com.shyms.corpormobile.ui.activity.BranchActivity;
import com.shyms.corpormobile.ui.adapter.AffairGuideAdapter;

import butterknife.Bind;

/**
 * Created by Weimin on 4/9/2016.
 */
public class AffairGuideFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @Bind(R.id.top_bar_left_image)
    protected ImageView mTopBarBack;
    @Bind(R.id.gv_guide)
    protected GridView mGridView;

    private AffairGuideAdapter mAdapter;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_guide_affair;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTopBarBack.setVisibility(View.INVISIBLE);
        mAdapter = new AffairGuideAdapter(mContext);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(mActivity, BranchActivity.class);
        startActivity(intent);

    }
}
