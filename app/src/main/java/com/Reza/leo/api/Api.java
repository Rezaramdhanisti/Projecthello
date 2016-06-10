package com.Reza.leo.api;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;


public class Api {
    //API BASE URL
    public static final String API_BASE_URL = "http://private-142c32-datausers.apiary-mock.com/";

    //Init Retrofit
    private static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setEndpoint(API_BASE_URL)
            .setClient(new OkClient(new OkHttpClient()));

    //Connect
    public static <S> S connect(Class<S> serviceClass) {
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }
}
