package com.frankstar.earthquake.controller;

import com.alibaba.fastjson.JSON;
import com.frankstar.earthquake.entity.EarthQuake;
import com.frankstar.earthquake.entity.NearCity;
import com.frankstar.earthquake.service.EarthQuakeHistoryInfoService;
import com.frankstar.earthquake.service.EarthQuakeInfoService;
import com.frankstar.earthquake.service.EarthQuakeNearCityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by frankstar on 2017/6/7.
 */
@Controller
@RequestMapping(value = "/info")
public class EarthQuakeController {

    @Autowired
    private EarthQuakeInfoService earthQuakeInfoService;

    @Autowired
    private EarthQuakeNearCityInfoService earthQuakeNearCityInfoService;

    @Autowired
    private EarthQuakeHistoryInfoService earthQuakeHistoryInfoService;

    /*@RequestMapping(value="/local",method = RequestMethod.GET)
    public String getAllEarthQuakeInfo(@RequestParam("pageNumber") int pageNumber, HttpServletRequest httpServletRequest) {

        List<EarthQuake> earthQuakeList = earthQuakeInfoService.getAllEarthQuakeInfo(pageNumber);
        httpServletRequest.setAttribute("earthQuakeList", earthQuakeList);

        return "getAll";
    }*/

    @RequestMapping(value="/local",method = RequestMethod.GET)
    public ModelAndView getAllEarthQuakeInfo(@RequestParam("pageNumber") int pageNumber) {

        List<EarthQuake> earthQuakeList = earthQuakeInfoService.getAllEarthQuakeInfo(pageNumber);
        ModelAndView mv = new ModelAndView("getAll");
        //将List对象转换为JSON对象
        String earthQuake = JSON.toJSONString(earthQuakeList);
        mv.addObject("earthQuake", earthQuake);

        return mv;
    }

    @RequestMapping(value="/history",method = RequestMethod.GET)
    public String getEarthQuakeHistoryInfo(@RequestParam("earth_id") int earth_id, HttpServletRequest httpServletRequest) {
        //httpServletRequest.setAttribute("earthQuakeList", earthQuakeList);

        List<EarthQuake> earthQuakeList = earthQuakeHistoryInfoService.getEarthQuakeHistoryInfo(earth_id);
        httpServletRequest.setAttribute("earthQuakeHistoryInfo", earthQuakeList);

        return "getHistory";
    }

    @RequestMapping(value="/near",method = RequestMethod.GET)
    public String getEarthQuakeNearCityInfo(@RequestParam("earth_id") int earth_id, HttpServletRequest httpServletRequest) {

        List<NearCity> nearCityList = earthQuakeNearCityInfoService.getEarthQuakeNearCity(earth_id);
        httpServletRequest.setAttribute("earthQuakeNearCityInfo", nearCityList);

        return "getNearCity";
    }


}
