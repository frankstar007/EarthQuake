package com.frankstar.earthquake.service;

import com.frankstar.earthquake.dao.EarthQuakeDAO;
import com.frankstar.earthquake.entity.EarthQuake;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frankstar on 2017/6/8.
 */
@Service
public interface EarthQuakeInfoService {

    public List<EarthQuake> getAllEarthQuakeInfo(int pageNumber);

    public EarthQuake getEarthQuakeInfo(int erath_id);



}
