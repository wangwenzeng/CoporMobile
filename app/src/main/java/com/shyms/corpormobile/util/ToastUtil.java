package com.shyms.corpormobile.util;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.shyms.corpormobile.R;
import com.shyms.corpormobile.base.BaseApplication;


public class ToastUtil {

    public static void shortShowTextBalckStyle(Activity context,
                                               CharSequence text) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.toast_layout, null);
        TextView textView = (TextView) view.findViewById(R.id.content);
        textView.setText(text);

        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void shortShowText(CharSequence text) {
        Toast.makeText(BaseApplication.context, text, Toast.LENGTH_SHORT).show();
    }

    public static void shortShowText(int textID) {
        Toast.makeText(BaseApplication.context, textID, Toast.LENGTH_SHORT).show();
    }

//    public static void longShowText(CharSequence text) {
//    }
//
//    public static void longShowText(int textID) {
//    }

    public static void showNoNetTip() {
        shortShowText(R.string.no_net_tip);
    }
}
