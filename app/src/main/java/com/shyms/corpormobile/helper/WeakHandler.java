package com.shyms.corpormobile.helper;

import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * Created by Weimin on 4/13/2016.
 */
abstract public class WeakHandler<T> extends Handler {
    private WeakReference<T> mOwner;

    public WeakHandler(T owner) {
        mOwner = new WeakReference<T>(owner);
    }

    public T getOwner() {
        return mOwner.get();
    }
}
