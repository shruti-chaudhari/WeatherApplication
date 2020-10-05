package com.shruti.weatherapplication.retrofit;

import com.shruti.weatherapplication.constants.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private static String baseUrl = String.format(Constants.BASE_URL);

    public static APIInterfaceClass getRetrofitClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(Constants.TIMEOUT_TIME, TimeUnit.MILLISECONDS)
                .readTimeout(Constants.TIMEOUT_TIME, TimeUnit.MILLISECONDS)
                .writeTimeout(Constants.TIMEOUT_TIME, TimeUnit.MILLISECONDS)
                .hostnameVerifier((s, sslSession) -> true)
                .addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


        return retrofit.create(APIInterfaceClass.class);
    }

}
