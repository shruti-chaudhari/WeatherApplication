package com.shruti.weatherapplication.retrofit;

import com.shruti.weatherapplication.constants.Constants;
import com.shruti.weatherapplication.dao.WeatherResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIInterfaceClass {

    @GET(Constants.weather )
    Call<WeatherResponse> getWeather(@QueryMap Map<String,String> options);
}
