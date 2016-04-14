package com.shyms.corpormobile.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseFragment;
import com.shyms.corpormobile.ui.activity.SampleActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Weimin on 4/12/2016.
 */
public class AffairProcessFragment extends BaseFragment {

    @Bind(R.id.top_bar_back)
    protected FrameLayout mBarBack;
    @Bind(R.id.top_bar_title)
    protected TextView mTitle;
    @Bind(R.id.tv_process_detail)
    protected TextView mProcessText;
    @Bind(R.id.btn_material_list)
    protected Button mMaterialist;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_affair_process;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBarBack.setVisibility(View.VISIBLE);
        mTitle.setText("具体流程标题");
    }


    @OnClick(R.id.top_bar_back)
    protected void onClickBack() {
        mActivity.onBackPressed();
    }

    @OnClick(R.id.btn_material_list)
    protected void onClickMaterialList() {

        startActivity(new Intent(mActivity, SampleActivity.class));

    }


}
