package com.frankstar.earthquake.service;

import com.frankstar.earthquake.dao.EarthQuakeLossDAO;
import com.frankstar.earthquake.entity.EarthQuakeLoss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by frankstar on 2017/6/10.
 */
@Service
public class EarthQuakeLossServiceImpl implements EarthQuakeLossService {

    @Autowired
    private EarthQuakeLossDAO earthQuakeLossDAO;

    @Override
    public EarthQuakeLoss getEarthQuakeLossByEarthID(int earth_id) {

        EarthQuakeLoss earthQuakeLoss = earthQuakeLossDAO.getEarthQuakeLossByEarthID(earth_id);
        return earthQuakeLoss;
    }

    @Override
    public void addEarthQuakeLoss(int earth_id, int death_people, int injury, double economy_loss, double destroy) {

        earthQuakeLossDAO.addEarthQuakeLoss(earth_id, death_people, injury, economy_loss, destroy);

    }
}
