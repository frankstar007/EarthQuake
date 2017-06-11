package com.frankstar.earthquake.controller;

import com.frankstar.earthquake.entity.EarthQuake;
import com.frankstar.earthquake.service.EarthQuakeHistoryInfoService;
import com.frankstar.earthquake.service.EarthQuakeInfoService;
import com.frankstar.earthquake.service.EarthQuakeNearCityInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by frankstar on 2017/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class TestController {

    @Autowired
    private EarthQuakeInfoService earthQuakeInfoService;

    @Autowired
    private EarthQuakeNearCityInfoService earthQuakeNearCityInfoService;

    @Autowired
    private EarthQuakeHistoryInfoService earthQuakeHistoryInfoService;

    @Test
    public void testGetAllEarthInfo() {

        List<EarthQuake> earthQuakeList = earthQuakeInfoService.getAllEarthQuakeInfo(1);
        for (EarthQuake e: earthQuakeList) {
            System.out.println(e.getEarthTitle());
        }

    }



}
