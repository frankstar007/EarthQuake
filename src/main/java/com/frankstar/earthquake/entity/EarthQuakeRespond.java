package com.frankstar.earthquake.entity;

/**
 * Created by frankstar on 2017/6/9.
 */
/*
* 地震响应方案
* */
public class EarthQuakeRespond {

    private int respond_id;

    private String respond_title;

    private String respond_lead;

    private String respond_organize;

    public int getRespond_id() {
        return respond_id;
    }

    public void setRespond_id(int respond_id) {
        this.respond_id = respond_id;
    }

    public String getRespond_title() {
        return respond_title;
    }

    public void setRespond_title(String respond_title) {
        this.respond_title = respond_title;
    }

    public String getRespond_lead() {
        return respond_lead;
    }

    public void setRespond_lead(String respond_lead) {
        this.respond_lead = respond_lead;
    }

    public String getRespond_organize() {
        return respond_organize;
    }

    public void setRespond_organize(String respond_organize) {
        this.respond_organize = respond_organize;
    }
}
