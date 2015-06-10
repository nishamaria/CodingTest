package com.westpac.assesment.weatherforecast.app.service;

import android.content.Context;
import android.util.Log;
import com.westpac.assesment.weatherforecast.app.R;
import retrofit.RestAdapter;

/**
 * Created by Nisha on 10/06/2015.
 */
public class WeatherForecastAdapter {

    private static final String TAG = "WeatherForecastAdapter";

    private static WeatherForecastAdapter mInstance = null;
    private RestAdapter mRestAdapter;

    private WeatherForecastAdapter(Context context) {
        String apiUrl = context.getResources().getString(R.string.apiServiceEndPoint)
                + context.getResources().getString(R.string.apiServiceKey);

        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(apiUrl)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String msg) {
                        Log.i(TAG, msg);
                    }
                }).build();
    }

    public static WeatherForecastAdapter getInstance() {
        return mInstance;
    }

    public RestAdapter getRestAdapter() {
        return mRestAdapter;
    }

    public static void create(Context context) {
        mInstance = new WeatherForecastAdapter(context);
    }

}
