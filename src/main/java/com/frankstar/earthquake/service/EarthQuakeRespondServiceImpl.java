package com.frankstar.earthquake.service;

import com.frankstar.earthquake.dao.EarthQuakeLossDAO;
import com.frankstar.earthquake.dao.EarthQuakeRespondDAO;
import com.frankstar.earthquake.dao.EarthRuleRespondDAO;
import com.frankstar.earthquake.entity.EarthQuakeLoss;
import com.frankstar.earthquake.entity.EarthQuakeRespond;
import com.frankstar.earthquake.entity.EarthRuleRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frankstar on 2017/6/10.
 */
@Service
public class EarthQuakeRespondServiceImpl implements EarthQuakeRespondService {

    @Autowired
    private EarthQuakeRespondDAO earthQuakeRespondDAO;

    @Autowired
    private EarthRuleRespondDAO earthRuleRespondDAO;

    @Autowired
    private EarthQuakeLossDAO earthQuakeLossDAO;

    @Override
    public List<EarthQuakeRespond> getAllEarthQuakeRespond() {

        List<EarthQuakeRespond> earthQuakeRespondList = earthQuakeRespondDAO.getAllEarthQuakeRespond();
        return earthQuakeRespondList;
    }

    @Override
    public EarthQuakeRespond getEarthQuakeRespondByRuleID(int rule_id) {

        EarthQuakeRespond earthQuakeRespond = earthQuakeRespondDAO.getEarthQuakeRespondByRespondID(earthRuleRespondDAO.getRespondIDByRuleID(rule_id));

        return earthQuakeRespond;
    }

    @Override
    public EarthQuakeRespond getEarthQuakeRespondByEarthID(int earth_id) {

        EarthQuakeLoss earthQuakeLoss = earthQuakeLossDAO.getEarthQuakeLossByEarthID(earth_id);
        EarthQuakeRespond earthQuakeRespond = null;

        if(earthQuakeLoss.getDeath_people() > 0) {
            //此处根据死亡人数 地震等级规则
            int death_people = earthQuakeLoss.getDeath_people();

            earthQuakeRespond = getEarthQuakeRespondByDeathPeople(death_people);

        }else if(earthQuakeLoss.getEconomy_loss() > 0) {
            //此处根据经济损失划分地震等级
            double economy_loss = earthQuakeLoss.getEconomy_loss();
            int rule_id = 0;

            earthQuakeRespond = getEarthQuakeRespondByEconomyLoss(economy_loss);

        }


        return earthQuakeRespond;
    }

    @Override
    public EarthQuakeRespond getEarthQuakeRespondByMagnitude(double magnitude) {

        EarthQuakeRespond earthQuakeRespond;

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

        earthQuakeRespond = earthQuakeRespondDAO.getEarthQuakeRespondByRespondID(earthRuleRespondDAO.getRespondIDByRuleID(rule_id));
        return earthQuakeRespond;
    }

    @Override
    public EarthQuakeRespond getEarthQuakeRespondByDeathPeople(int death_people) {

        EarthQuakeRespond earthQuakeRespond;

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

        earthQuakeRespond = earthQuakeRespondDAO.getEarthQuakeRespondByRespondID(earthRuleRespondDAO.getRespondIDByRuleID(rule_id));
        return earthQuakeRespond;
    }

    @Override
    public EarthQuakeRespond getEarthQuakeRespondByEconomyLoss(double economy_loss) {

        EarthQuakeRespond earthQuakeRespond;
        int rule_id = 0;
        //进行逻辑判断
        if(economy_loss > 0.1) {
            rule_id = 4;
        }

        earthQuakeRespond = earthQuakeRespondDAO.getEarthQuakeRespondByRespondID(earthRuleRespondDAO.getRespondIDByRuleID(rule_id));
        return earthQuakeRespond;
    }
}
