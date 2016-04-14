package com.shyms.corpormobile.net;


import android.util.Log;

import com.shyms.corpormobile.constants.GlobalConstant;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Weimin on 4/7/2016.
 */
public class NetRequest {

    public final static String BASE_URL = "https://cs.yatesun.com/fryms/api/";
    public static APIClient APIInstance;
    public static Cache cache;

    static {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        Log.d(GlobalConstant.TAG, "HttpLoggingInterceptor");
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();
        Log.d(GlobalConstant.TAG, "建立okhttp对象");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d(GlobalConstant.TAG, "建立retrofit对象");
        APIInstance = retrofit.create(APIClient.class);
        Log.d(GlobalConstant.TAG, "APIInstance类已经建立");

    }
}
