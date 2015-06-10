package com.westpac.assesment.weatherforecast.app.ui;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.westpac.assesment.weatherforecast.app.ForecastApplication;
import com.westpac.assesment.weatherforecast.app.R;
import com.westpac.assesment.weatherforecast.app.service.model.ForecastResponse;
import com.westpac.assesment.weatherforecast.app.service.model.Request;
import com.westpac.assesment.weatherforecast.app.util.ConnectivityUtil;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ForecastMainActivity extends Activity {

    private static final String TAG = "ForecastMainActivity";

    private TextView summaryTextView;
    private TextView forecastTextView;
    private TextView timeTextView;
    private TextView temperatureTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_main);

        initializeUI();
        requestWeatherForecast();
    }

    private void initializeUI() {
        summaryTextView = (TextView) findViewById(R.id.summaryInfoTextView);
        forecastTextView = (TextView) findViewById(R.id.forecastInfoTextView);
        timeTextView = (TextView) findViewById(R.id.timeInfoTextView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureInfoTextView);
    }

    private void requestWeatherForecast(){

        if (ConnectivityUtil.isNetworkConnected(this)) {

            Location currentLocation = ConnectivityUtil.getCurrentLocation(getApplicationContext());

            if (currentLocation != null) {
                Request request = new Request();
                request.setLatitude(String.valueOf(currentLocation.getLatitude()));
                request.setLongitude(String.valueOf(currentLocation.getLongitude()));

                ForecastApplication.getWeatherServiceManager().requestWeatherForecast(request, new Callback<ForecastResponse>() {
                    @Override
                    public void success(ForecastResponse weatherResponse, Response response) {
                        updateUIData(weatherResponse);
                    }

                    @Override
                    public void failure(RetrofitError retrofitError) {
                        Log.d(TAG, "Error calling the api: " + retrofitError.getUrl());
                        Log.d(TAG, retrofitError.toString());
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.err_calling_api), Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                Toast.makeText(this, getResources().getString(R.string.err_location), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, getResources().getString(R.string.err_network), Toast.LENGTH_LONG).show();
        }
    }

    private void updateUIData(ForecastResponse weatherResponse){
        summaryTextView.setText(weatherResponse.getCurrently().getSummary());
        forecastTextView.setText(weatherResponse.getCurrently().getIcon());
        timeTextView.setText(String.valueOf(weatherResponse.getCurrently().getTime()));
        temperatureTextView.setText(String.valueOf(weatherResponse.getCurrently().getTemperature()));
    }


    @Override
    protected void onStart() {
        super.onStart();
        requestWeatherForecast();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
