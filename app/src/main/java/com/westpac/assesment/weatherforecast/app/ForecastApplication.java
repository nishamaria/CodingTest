package com.westpac.assesment.weatherforecast.app;

import android.app.Application;
import android.content.Context;
import com.westpac.assesment.weatherforecast.app.service.IWeatherService;
import com.westpac.assesment.weatherforecast.app.service.IWeatherServiceManager;
import com.westpac.assesment.weatherforecast.app.service.WeatherForecastAdapter;
import com.westpac.assesment.weatherforecast.app.service.WeatherServiceManager;
import retrofit.RestAdapter;

public class ForecastApplication extends Application {

    private static Context context;
    private static RestAdapter restAdapter;
    private static IWeatherServiceManager weatherServiceManager;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        WeatherForecastAdapter.create(context);
        restAdapter = WeatherForecastAdapter.getInstance().getRestAdapter();
        weatherServiceManager = new WeatherServiceManager(restAdapter.create(IWeatherService.class));
    }

    public static IWeatherServiceManager getWeatherServiceManager() {
        return weatherServiceManager;
    }
}
