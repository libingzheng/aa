package com.example.myapplication.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private  Retrofit retrofit;
    private static RetrofitUtil retrofitUtil;
    private RetrofitUtil(){
        retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtil getInstance() {
        if (retrofitUtil==null){
            synchronized (RetrofitUtil.class){
                retrofitUtil=new RetrofitUtil();
            }
        }
        return retrofitUtil;
    }
}
