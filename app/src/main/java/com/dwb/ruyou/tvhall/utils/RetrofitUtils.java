package com.dwb.ruyou.tvhall.utils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Slayer on 2017/6/5.
 */

public class RetrofitUtils {

    public static <T> T getRestofitApi(String baseUrl,Class<T> service){

        Interceptor interceptor=new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;

                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
                        .addQueryParameter("platform", "android")
                        .addQueryParameter("version", "1.0.0")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(service);
    }


    public static <T> T geCachetRetofitApi(String baseUrl, Class<T> service){

//        //缓存路径
//        File cacheFile = new File(.getCacheDir().getAbsolutePath(), "HttpCache");
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 10);//缓存文件为10MB

        return null;
    }
}
