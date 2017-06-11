package com.frankstar.earthquake.service;

import com.frankstar.earthquake.dao.EarthQuakeHistoryDAO;
import com.frankstar.earthquake.entity.EarthQuake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frankstar on 2017/6/8.
 */
@Service
public interface EarthQuakeHistoryInfoService {

    public void addEarthQuakeHistory(int earth_id, int earth_history);

    public List<EarthQuake> getEarthQuakeHistoryInfo(int earth_id);
}
