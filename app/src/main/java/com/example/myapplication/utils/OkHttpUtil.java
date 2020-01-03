package com.example.myapplication.utils;

import android.os.Handler;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtil {
    Handler handler=new Handler();
    private static OkHttpUtil okHttpUtil;
    private OkHttpClient client;
    private OkHttpUtil(){
        client=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    public static OkHttpUtil getInstance() {
        if (okHttpUtil==null){
            synchronized (OkHttpUtil.class){
                if (okHttpUtil==null){
                    okHttpUtil=new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }
    public void doGet(String url, final OkCallBack callBack){
        Request request=new Request.Builder()
                .url(url)
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callBack.onError(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                if (okHttpUtil!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                callBack.onSuccess(response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }
    interface OkCallBack{
        void onSuccess(String e);
        void onError(Throwable throwable);
    }
}
