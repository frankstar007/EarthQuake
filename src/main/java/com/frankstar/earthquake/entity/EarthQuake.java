package com.frankstar.earthquake.entity;

import java.util.Date;

/**
 * Created by frankstar on 2017/6/7.
 */
public class EarthQuake {

    private int earthId;

    private String earthTitle;

    private Date earthTime;

    private double longitude;

    private double latitude;

    private int deepth;

    private double magnitude;

    private String city;

    public int getEarthId() {
        return earthId;
    }

    public void setEarthId(int earthId) {
        this.earthId = earthId;
    }

    public String getEarthTitle() {
        return earthTitle;
    }

    public void setEarthTitle(String earthTitle) {
        this.earthTitle = earthTitle;
    }

    public Date getEarthTime() {
        return earthTime;
    }

    public void setEarthTime(Date earthTime) {
        this.earthTime = earthTime;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getDeepth() {
        return deepth;
    }

    public void setDeepth(int deepth) {
        this.deepth = deepth;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
