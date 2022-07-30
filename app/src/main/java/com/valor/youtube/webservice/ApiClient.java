package com.valor.youtube.webservice;



import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.valor.youtube.utils.AppConstant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(Level.BODY);
        Builder httpClient = new Builder();
        httpClient.addInterceptor(logging);
        return buildRetrofit(httpClient);
    }

    @NonNull
    private static Retrofit buildRetrofit(Builder httpClient) {
        httpClient.connectTimeout(1, TimeUnit.MINUTES);
        httpClient.readTimeout(5, TimeUnit.MINUTES);
        httpClient.writeTimeout(5, TimeUnit.MINUTES);
        Gson gson = new GsonBuilder().setLenient().create();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(AppConstant.URL)
                    .client(httpClient.build()).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }
}
