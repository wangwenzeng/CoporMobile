package com.shyms.corpormobile.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.shyms.corpormobile.R;

/**
 * Created by Weimin on 4/12/2016.
 */
public class GotoHelper {
    public static void gotoActivity(Context context, Class<? extends Activity> cls, Bundle args) {
        if (context == null) return;

        Intent intent = new Intent(context, cls);
        if (args != null) intent.putExtras(args);

        context.startActivity(intent);
    }

    public static void gotoActivity(Context context, Class<? extends Activity> cls) {
        gotoActivity(context, cls, null);
    }

    public static void gotoActivityForResult(Activity activity, Class<? extends Activity> cls, int requestCode, Bundle args) {
        if (activity == null) return;

        Intent intent = new Intent(activity, cls);
        if (args != null) intent.putExtras(args);

        activity.startActivityForResult(intent, requestCode);
    }

    public static void gotoActivityForResult(Activity activity, Class<? extends Activity> cls, int requestCode) {
        gotoActivityForResult(activity, cls, requestCode, null);
    }

    public static void gotoFragment(FragmentManager fm, Fragment fragment, Bundle args) {
        if (fm == null) return;
        if (args != null) fragment.setArguments(args);

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.container_main_page, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();

    }

    public static void gotoFragment(FragmentManager fm, Fragment fragment) {
        gotoFragment(fm, fragment, null);
    }


}
