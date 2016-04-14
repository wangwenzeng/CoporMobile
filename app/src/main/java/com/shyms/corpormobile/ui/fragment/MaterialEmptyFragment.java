package com.shyms.corpormobile.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseFragment;

import butterknife.Bind;

/**
 * Created by Weimin on 4/12/2016.
 */
public class MaterialEmptyFragment extends BaseFragment {

    @Bind(R.id.top_bar_back)
    FrameLayout mBarBack;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_material_empty;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBarBack.setVisibility(View.VISIBLE);
    }
}
