package com.frankstar.earthquake.entity;

/**
 * Created by frankstar on 2017/6/8.
 */
public class NearCity {

    private int nearCityId;

    private String city;

    private double distance;

    public int getNearCityId() {
        return nearCityId;
    }

    public void setNearCityId(int nearCityId) {
        this.nearCityId = nearCityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
