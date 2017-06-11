package com.frankstar.earthquake.service;

import com.frankstar.earthquake.entity.EarthQuakeRespond;
import com.frankstar.earthquake.entity.EarthRuleRespond;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frankstar on 2017/6/10.
 */
@Service
public interface EarthQuakeRespondService {

    public List<EarthQuakeRespond> getAllEarthQuakeRespond();

    public EarthQuakeRespond getEarthQuakeRespondByRuleID(int rule_id);

    public EarthQuakeRespond getEarthQuakeRespondByEarthID(int earth_id);

    public EarthQuakeRespond getEarthQuakeRespondByMagnitude(double magnitude);

    public EarthQuakeRespond getEarthQuakeRespondByDeathPeople(int death_people);

    public EarthQuakeRespond getEarthQuakeRespondByEconomyLoss(double economy_loss);

}
