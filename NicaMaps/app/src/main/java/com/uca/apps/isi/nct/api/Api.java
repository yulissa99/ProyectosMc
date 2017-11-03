package com.uca.apps.isi.nct.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private final static String URL = "https://api-complaint.herokuapp.com/api";

    public static String getBase() {
        return URL + "/";
    }

    public static ApiInterface instance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.getBase())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }

}