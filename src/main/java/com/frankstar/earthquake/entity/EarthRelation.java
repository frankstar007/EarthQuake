package com.frankstar.earthquake.entity;

/**
 * Created by frankstar on 2017/6/8.
 */
public class EarthRelation {
    private int id;

    private int earth_id;

    private int earth_history;

    private int earth_near;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEarth_id() {
        return earth_id;
    }

    public void setEarth_id(int earth_id) {
        this.earth_id = earth_id;
    }

    public int getEarth_history() {
        return earth_history;
    }

    public void setEarth_history(int earth_history) {
        this.earth_history = earth_history;
    }

    public int getEarth_near() {
        return earth_near;
    }

    public void setEarth_near(int earth_near) {
        this.earth_near = earth_near;
    }
}
