package com.frankstar.earthquake.service;

import com.frankstar.earthquake.entity.EarthQuakeLoss;
import org.springframework.stereotype.Service;

/**
 * Created by frankstar on 2017/6/10.
 */
@Service
public interface EarthQuakeLossService {

    public EarthQuakeLoss getEarthQuakeLossByEarthID(int earth_id);

    public void addEarthQuakeLoss(int earth_id, int death_people, int injury, double economy_loss, double destroy);

}
