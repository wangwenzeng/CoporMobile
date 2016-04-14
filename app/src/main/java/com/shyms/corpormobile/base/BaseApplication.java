package com.shyms.corpormobile.base;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.shyms.corpormobile.util.SPUtil;

/**
 * Created by Weimin on 4/7/2016.
 */
public class BaseApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler(this));
        if (context == null) {
            context = this;
        }
        SPUtil.init(context);
        Fresco.initialize(context);

    }


}
