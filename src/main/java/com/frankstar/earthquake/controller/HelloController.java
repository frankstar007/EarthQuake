package com.frankstar.earthquake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by frankstar on 2017/6/6.
 */

@Controller
public class HelloController {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(ModelMap model) {
        model.addAttribute("msg", "Spring 3 MVC Hello World");
        return "hello";
    }
}
