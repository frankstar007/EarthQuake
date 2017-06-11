package com.frankstar.earthquake.service;

import com.frankstar.earthquake.dao.EarthQuakeLossDAO;
import com.frankstar.earthquake.dao.EarthQuakeRuleDAO;
import com.frankstar.earthquake.entity.EarthQuakeLoss;
import com.frankstar.earthquake.entity.EarthQuakeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frankstar on 2017/6/10.
 */
@Service
public class EarthQuakeRuleServiceImpl implements EarthQuakeRuleService {

    @Autowired
    private EarthQuakeRuleDAO earthQuakeRuleDAO;

    @Autowired
    private EarthQuakeLossDAO earthQuakeLossDAO;

    @Override
    public List<EarthQuakeRule> getAllEarthQuakeRule() {
        return earthQuakeRuleDAO.getAllEarthQuakeRule();
    }

    @Override
    public EarthQuakeRule getEarthQuakeRuleByRuleID(int rule_id) {
        return earthQuakeRuleDAO.getEarthQuakeRuleByRuleID(rule_id);
    }

    @Override
    public EarthQuakeRule getEarthQuakeRuleByEarthMagnitude(double magnitude) {

        EarthQuakeRule earthQuakeRule;
        int rule_id = 0;
        //进行逻辑判断
        if (magnitude >= 7.0) {
            rule_id = 4;
        }else if(magnitude < 7.0 && magnitude >= 6.5) {
            rule_id = 1;
        }else if(magnitude < 6.5 && magnitude >= 6) {
            rule_id = 2;
        }else if(magnitude < 6.0 && magnitude >= 0) {
            rule_id = 3;
        }
        earthQuakeRule = getEarthQuakeRuleByRuleID(rule_id);
        return earthQuakeRule;
    }

    @Override
    public EarthQuakeRule getEarthQuakeRuleByDeathPeople(int death_people) {

        EarthQuakeRule earthQuakeRule;
        int rule_id = 0;
        //进行逻辑判断
        if(death_people >= 300) {
            rule_id = 4;
        }else if (death_people < 300 && death_people >= 50) {
            rule_id = 1;
        }else if (death_people < 50 && death_people >= 20) {
            rule_id = 2;
        }else if (death_people < 20 && death_people >= 0 ) {
            rule_id = 3;
        }
        earthQuakeRule = getEarthQuakeRuleByRuleID(rule_id);
        return earthQuakeRule;
    }

    @Override
    public EarthQuakeRule getEarthQuakeRuleByEconomyLoss(double economy_loss) {

        EarthQuakeRule earthQuakeRule;
        int rule_id = 0;
        //进行逻辑判断
        if(economy_loss > 0.1) {
            rule_id = 4;
        }
        earthQuakeRule = getEarthQuakeRuleByRuleID(rule_id);
        return earthQuakeRule;
    }

    @Override
    public EarthQuakeRule getEarthQuakeRuleByEarthID(int earth_id) {

        EarthQuakeRule earthQuakeRule = null;
        EarthQuakeLoss earthQuakeLoss = earthQuakeLossDAO.getEarthQuakeLossByEarthID(earth_id);

        if(earthQuakeLoss.getDeath_people() > 0) {
            int death_people = earthQuakeLoss.getDeath_people();
            earthQuakeRule = getEarthQuakeRuleByDeathPeople(death_people);
        }else if(earthQuakeLoss.getEconomy_loss() > 0) {
            double economy_loss = earthQuakeLoss.getEconomy_loss();
            earthQuakeRule = getEarthQuakeRuleByEconomyLoss(economy_loss);
        }

        return earthQuakeRule;
    }
}
