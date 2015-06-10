package com.westpac.assesment.weatherforecast.app.service.model;

public class DataPoint {

    private String summary;
    private String icon;
    private long time;
    private double temperature;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public long getTime() {
        return time;
    }

    public double getTemperature() {
        return temperature;
    }

}
