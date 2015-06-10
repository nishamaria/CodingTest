package com.westpac.assesment.weatherforecast.app.service.model;

/**
 * Created by Nisha on 10/06/2015.
 */
public class Request {

    private String mLatitude;
    private String mLongitude;

    public String getLongitude() {
        return mLongitude;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLongitude(String mLongitude) {
        this.mLongitude = mLongitude;
    }

    public void setLatitude(String mLatitude) {
        this.mLatitude = mLatitude;
    }

    @Override
    public String toString() {
        String params = mLatitude + "," + mLongitude;
        return  params;
    }

}
