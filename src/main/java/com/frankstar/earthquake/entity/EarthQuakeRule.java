package com.frankstar.earthquake.entity;

/**
 * Created by frankstar on 2017/6/9.
 */
/*
* 地震等级规则
* */
public class EarthQuakeRule {

    private int rule_id;

    private int max_death;

    private int min_death;

    private double economy_loss;

    private double min_magnitude;

    private double max_magnitude;

    private String rule_title;

    public int getRule_id() {
        return rule_id;
    }

    public void setRule_id(int rule_id) {
        this.rule_id = rule_id;
    }

    public int getMax_death() {
        return max_death;
    }

    public void setMax_death(int max_death) {
        this.max_death = max_death;
    }

    public int getMin_death() {
        return min_death;
    }

    public void setMin_death(int min_death) {
        this.min_death = min_death;
    }

    public double getEconomy_loss() {
        return economy_loss;
    }

    public void setEconomy_loss(double economy_loss) {
        this.economy_loss = economy_loss;
    }

    public double getMin_magnitude() {
        return min_magnitude;
    }

    public void setMin_magnitude(double min_magnitude) {
        this.min_magnitude = min_magnitude;
    }

    public double getMax_magnitude() {
        return max_magnitude;
    }

    public void setMax_magnitude(double max_magnitude) {
        this.max_magnitude = max_magnitude;
    }

    public String getRule_title() {
        return rule_title;
    }

    public void setRule_title(String rule_title) {
        this.rule_title = rule_title;
    }
}
