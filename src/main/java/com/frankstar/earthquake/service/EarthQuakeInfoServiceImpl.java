package com.frankstar.earthquake.service;

import com.frankstar.earthquake.dao.EarthQuakeDAO;
import com.frankstar.earthquake.entity.EarthQuake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frankstar on 2017/6/8.
 */
@Service
public class EarthQuakeInfoServiceImpl implements EarthQuakeInfoService {

    @Autowired
    private EarthQuakeDAO earthQuakeDAO;

    @Override
    public List<EarthQuake> getAllEarthQuakeInfo(int pageNumber) {

        List<EarthQuake> earthQuakeList = earthQuakeDAO.getAllEarthQuake(pageNumber);
        return earthQuakeList;
    }

    @Override
    public EarthQuake getEarthQuakeInfo(int earth_id) {

        EarthQuake earthQuake = earthQuakeDAO.getEarthQuakeByID(earth_id);
        return earthQuake;
    }
}
