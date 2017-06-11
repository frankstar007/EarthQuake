package com.frankstar.earthquake.service;

import com.frankstar.earthquake.entity.EarthQuakeRule;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frankstar on 2017/6/10.
 */
@Service
public interface EarthQuakeRuleService {

    public List<EarthQuakeRule> getAllEarthQuakeRule();

    public EarthQuakeRule getEarthQuakeRuleByRuleID(int rule_id);

    public EarthQuakeRule getEarthQuakeRuleByEarthMagnitude(double magnitude);

    public EarthQuakeRule getEarthQuakeRuleByDeathPeople(int death_people);

    public EarthQuakeRule getEarthQuakeRuleByEconomyLoss(double economy_loss);

    public EarthQuakeRule getEarthQuakeRuleByEarthID(int earth_id);
}
