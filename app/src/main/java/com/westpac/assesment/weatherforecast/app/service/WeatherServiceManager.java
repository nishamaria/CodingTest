package com.westpac.assesment.weatherforecast.app.service;

import com.westpac.assesment.weatherforecast.app.service.model.ForecastResponse;
import com.westpac.assesment.weatherforecast.app.service.model.Request;
import retrofit.Callback;

/**
 * Created by Nisha on 10/06/2015.
 */
public class WeatherServiceManager implements IWeatherServiceManager{

    private IWeatherService weatherService;

    public WeatherServiceManager(IWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public void requestWeatherForecast(Request request, Callback<ForecastResponse> callback) {
        weatherService.getWeatherForecast(request, callback);
    }

    @Override
    public IWeatherService getWeatherService() {
        return weatherService;
    }
}
