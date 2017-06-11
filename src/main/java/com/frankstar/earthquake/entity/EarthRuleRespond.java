package com.frankstar.earthquake.entity;

/**
 * Created by frankstar on 2017/6/10.
 */
public class EarthRuleRespond {

    private int id;

    private int rule_id;

    private int respond_id;

    public int getRule_id() {
        return rule_id;
    }

    public void setRule_id(int rule_id) {
        this.rule_id = rule_id;
    }

    public int getRespond_id() {
        return respond_id;
    }

    public void setRespond_id(int respond_id) {
        this.respond_id = respond_id;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
