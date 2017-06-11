package com.frankstar.earthquake.controller;

import com.frankstar.earthquake.entity.EarthQuakeRule;
import com.frankstar.earthquake.service.EarthQuakeRespondService;
import com.frankstar.earthquake.service.EarthQuakeRuleService;
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
@RequestMapping(value = "/rule")
public class EarthQuakeRuleController {

    @Autowired
    private EarthQuakeRuleService earthQuakeRuleService;

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public String getAllEarthRule(HttpServletRequest httpServletRequest) {

        List<EarthQuakeRule> earthQuakeRuleList = earthQuakeRuleService.getAllEarthQuakeRule();
        httpServletRequest.setAttribute("earthQuakeRuleList", earthQuakeRuleList);

        return "allEarthRule";

    }

    @RequestMapping(value="/earthID",method = RequestMethod.GET)
    public String getEarthRuleByEarthID(@RequestParam("earth_id") int earth_id, HttpServletRequest httpServletRequest) {

        EarthQuakeRule earthQuakeRule = earthQuakeRuleService.getEarthQuakeRuleByEarthID(earth_id);
        httpServletRequest.setAttribute("earthQuakeRule", earthQuakeRule);

        return "earthRule";

    }




}
