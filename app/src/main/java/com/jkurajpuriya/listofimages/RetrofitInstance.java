package com.jkurajpuriya.listofimages;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    public static RetrofitInstance instance;
    ApiInterface apiInterface;

    RetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface=retrofit.create(ApiInterface.class);
    }
    public static RetrofitInstance getInstance(){
        if (instance==null){
            instance=new RetrofitInstance();
        }
        return instance;
    }
}
