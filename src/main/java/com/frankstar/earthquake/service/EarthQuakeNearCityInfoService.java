package com.frankstar.earthquake.service;

import com.frankstar.earthquake.entity.NearCity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frankstar on 2017/6/8.
 */
@Service
public interface EarthQuakeNearCityInfoService {

    public void addEarthQuakeNearCityInfo(int earth_id, int earth_near);

    public List<NearCity> getEarthQuakeNearCity(int earth_id);

}

