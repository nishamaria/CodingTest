package com.westpac.assesment.weatherforecast.app.service;

import com.westpac.assesment.weatherforecast.app.service.model.ForecastResponse;
import com.westpac.assesment.weatherforecast.app.service.model.Request;
import retrofit.Callback;

/**
 * Created by Nisha on 10/06/2015.
 */
public interface IWeatherServiceManager {

    void requestWeatherForecast(Request request, Callback<ForecastResponse> callback);

    IWeatherService getWeatherService();
}
