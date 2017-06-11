package com.frankstar.earthquake.controller;

import com.frankstar.earthquake.entity.EarthQuakeRespond;
import com.frankstar.earthquake.entity.EarthQuakeRule;
import com.frankstar.earthquake.service.EarthQuakeRespondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by frankstar on 2017/6/10.
 */
@Controller
@RequestMapping(value = "/respond")
public class EarthQuakeRespondController {

    @Autowired
    private EarthQuakeRespondService earthQuakeRespondService;

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public String getAllEarthRespond(HttpServletRequest httpServletRequest) {

        List<EarthQuakeRespond> earthQuakeRespondList = earthQuakeRespondService.getAllEarthQuakeRespond();
        httpServletRequest.setAttribute("earthQuakeRespondList", earthQuakeRespondList);

        return "allEarthRespond";

    }

    @RequestMapping(value="/earthID",method = RequestMethod.GET)
    public String getEarthRuleByEarthID(@RequestParam("earth_id") int earth_id, HttpServletRequest httpServletRequest) {

        EarthQuakeRespond earthQuakeRespond = earthQuakeRespondService.getEarthQuakeRespondByEarthID(earth_id);
        httpServletRequest.setAttribute("earthQuakeRespond", earthQuakeRespond);

        return "earthRespond";

    }
}
