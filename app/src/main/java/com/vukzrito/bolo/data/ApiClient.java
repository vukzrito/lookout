package com.vukzrito.bolo.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


class ApiClient {
    private static final String BASE_URL = "http://localhost:3000";
    private static Retrofit retrofit = null;

    static Retrofit getClient() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}