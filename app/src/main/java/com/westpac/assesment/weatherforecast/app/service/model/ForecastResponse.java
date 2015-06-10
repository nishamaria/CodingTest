package com.westpac.assesment.weatherforecast.app.service.model;

/**
 * Created by Nisha on 9/06/2015.
 */
public class ForecastResponse {

    private DataPoint currently;

    public void setCurrently(DataPoint currently) {
        this.currently = currently;
    }

    public DataPoint getCurrently() {
        return currently;
    }

}
