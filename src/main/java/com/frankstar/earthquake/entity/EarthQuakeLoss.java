package com.frankstar.earthquake.entity;

/**
 * Created by frankstar on 2017/6/9.
 */
public class EarthQuakeLoss {

    private int id;

    private int earth_id;

    private int death_people;

    private double economy_loss;

    private double destroy;

    private int injury;

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

    public int getDeath_people() {
        return death_people;
    }

    public void setDeath_people(int death_people) {
        this.death_people = death_people;
    }

    public double getEconomy_loss() {
        return economy_loss;
    }

    public void setEconomy_loss(double economy_loss) {
        this.economy_loss = economy_loss;
    }

    public double getDestroy() {
        return destroy;
    }

    public void setDestroy(double destroy) {
        this.destroy = destroy;
    }

    public int getInjury() {
        return injury;
    }

    public void setInjury(int injury) {
        this.injury = injury;
    }
}
