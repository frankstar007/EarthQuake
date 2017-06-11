package com.frankstar.earthquake.dao;

import com.frankstar.earthquake.entity.EarthRuleRespond;

import java.util.List;

/**
 * Created by frankstar on 2017/6/10.
 */
public interface EarthRuleRespondDAO {

    /*
    * 列出所有的对应关系
    * */
    public List<EarthRuleRespond> getAllEarthRuleRespond();

    /*
    *  根据rule_id 查询对应的respond_id
    * */
    public int getRespondIDByRuleID(int rule_id);

    /*
    *    根据respond_id 查询对应的rule_id
    * */
    public int getRuleIDByRespondID(int respond_id);
}
