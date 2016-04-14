package com.shyms.corpormobile.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shyms.corpormobile.R;

/**
 * Created by Weimin on 4/12/2016.
 */
public class LoadingDialog extends DialogFragment {

    private int resId = -1;

    public LoadingDialog() {
        // Empty constructor required for DialogFragment
    }

    public static LoadingDialog newInstance() {
        return newInstance(-1);
    }

    public static LoadingDialog newInstance(int resId) {
        LoadingDialog f = new LoadingDialog();
        f.resId = resId;
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loading, container);
        if (resId > 0) {
            ImageView loadingImage = (ImageView) view.findViewById(R.id.loading_image);
            loadingImage.setImageResource(resId);
        }
        this.getDialog().setTitle(R.string.load_dialog_loading);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme);
        return view;
    }
}


