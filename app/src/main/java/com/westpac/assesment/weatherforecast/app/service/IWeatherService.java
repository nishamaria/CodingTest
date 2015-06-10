package com.westpac.assesment.weatherforecast.app.service;

import com.westpac.assesment.weatherforecast.app.service.model.Request;
import com.westpac.assesment.weatherforecast.app.service.model.ForecastResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;


public interface IWeatherService {

    @GET("/{request}")
    void getWeatherForecast(@Path("request") Request params, Callback<ForecastResponse> cb);

}
