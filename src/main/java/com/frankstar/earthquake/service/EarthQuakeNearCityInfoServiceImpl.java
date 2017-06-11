package com.frankstar.earthquake.service;

import com.frankstar.earthquake.dao.EarthQuakeDAO;
import com.frankstar.earthquake.dao.EarthQuakeNearCityDAO;
import com.frankstar.earthquake.entity.EarthRelation;
import com.frankstar.earthquake.entity.NearCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frankstar on 2017/6/8.
 */
@Service
public class EarthQuakeNearCityInfoServiceImpl implements EarthQuakeNearCityInfoService{


    @Autowired
    private EarthQuakeNearCityDAO earthQuakeNearCityDAO;

    @Override
    public void addEarthQuakeNearCityInfo(int earth_id, int earth_near) {

        earthQuakeNearCityDAO.addEarthQuakeNearCity(earth_id, earth_near);

    }

    @Override
    public List<NearCity> getEarthQuakeNearCity(int earth_id) {

        List<EarthRelation> earthRelationList = earthQuakeNearCityDAO.getEarthRelationByEarthID(earth_id);
        List<Integer> nearCityId = new ArrayList<>();
        for (EarthRelation e: earthRelationList) {

            nearCityId.add(e.getEarth_near());
        }
        List<NearCity> nearCityList = earthQuakeNearCityDAO.getNearCityInfoByEarthNearID(nearCityId);

        return nearCityList;
    }
}
