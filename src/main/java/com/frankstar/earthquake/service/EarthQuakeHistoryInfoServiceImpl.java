package com.frankstar.earthquake.service;

import com.frankstar.earthquake.dao.EarthQuakeDAO;
import com.frankstar.earthquake.dao.EarthQuakeHistoryDAO;
import com.frankstar.earthquake.entity.EarthQuake;
import com.frankstar.earthquake.entity.EarthRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frankstar on 2017/6/8.
 */
@Service
public class EarthQuakeHistoryInfoServiceImpl implements EarthQuakeHistoryInfoService {

    @Autowired
    private EarthQuakeHistoryDAO earthQuakeHistoryDAO;

    @Autowired
    private EarthQuakeDAO earthQuakeDAO;

    @Override
    public void addEarthQuakeHistory(int earth_id, int earth_history) {

        earthQuakeHistoryDAO.addEarthQuakeHistory(earth_id, earth_history);
    }

    @Override
    public List<EarthQuake> getEarthQuakeHistoryInfo(int earth_id) {

        List<EarthRelation> earthRelationList = earthQuakeHistoryDAO.getEarthRelationByEarthId(earth_id);
        List<Integer> earthQuakeHistoryID = new ArrayList<>();
        for (EarthRelation e: earthRelationList) {
            earthQuakeHistoryID.add(e.getEarth_history());
        }
        List<EarthQuake> earthQuakeList = earthQuakeDAO.getEarthQuakeByID(earthQuakeHistoryID);

        return earthQuakeList;
    }
}
