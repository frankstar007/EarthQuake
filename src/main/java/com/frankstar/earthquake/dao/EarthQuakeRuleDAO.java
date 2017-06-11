package com.frankstar.earthquake.dao;

import com.frankstar.earthquake.entity.EarthQuakeRule;

import java.util.List;

/**
 * Created by frankstar on 2017/6/9.
 */
public interface EarthQuakeRuleDAO {


    /*
    * 列出所有地震确定等级规则
    * */
    public List<EarthQuakeRule> getAllEarthQuakeRule();

    /*
    * 根据rule_id获取等级规则
    * int rule_id
    * */
    public EarthQuakeRule getEarthQuakeRuleByRuleID(int rule_id);


    // 一下的接口 应该放在服务层
    /*
    * 根据地震震级划分地震等级
    *
    * double earth_magnitude
    * */
   /* public EarthQuakeRule getEarthQuakeRuleByEarthMagnitude(double magnitude);

    *//*
    * 根据死伤人数来划分地震等级
    * int death_people
    * *//*
    public EarthQuakeRule getEarthQuakeRuleByDeathPeople(int death_people);

    *//*
    * 根据经济损失来划分地震等级
    * double economy_loss
    * *//*
    public EarthQuakeRule getEarthQuakeRuleByEconomyLoss(double economy_loss);

    *//*
    * 根据地震ID 划分地震等级
    * int earth_id
    * 这个暂定可以放在服务层
    * *//*
    public EarthQuakeRule getEarthQuakeRuleByEarthID(int earth_id);*/


}
