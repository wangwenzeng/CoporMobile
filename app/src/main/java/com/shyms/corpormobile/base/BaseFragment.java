package com.shyms.corpormobile.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    protected final static int DEFAULT_MENU_RES = -1;
    protected View mRootView;
    protected Activity mActivity;
    protected Context mContext;

    abstract protected int getLayoutResID();

    @Override
    @CallSuper
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
        mContext = context;

    }

    @Nullable
    @Override
    @CallSuper
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


            mRootView = inflater.inflate(getLayoutResID(), container, false);
            ButterKnife.bind(this, mRootView);

        if (getMenuLayoutResID() != DEFAULT_MENU_RES) {
            setHasOptionsMenu(true);
        }
        return mRootView;
    }

    protected int getMenuLayoutResID() {
        return DEFAULT_MENU_RES;
    }

    @Override
    @CallSuper
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (getMenuLayoutResID() != DEFAULT_MENU_RES) {
            menu.clear();
            inflater.inflate(getMenuLayoutResID(), menu);
        } else {
            super.onCreateOptionsMenu(menu, inflater);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
