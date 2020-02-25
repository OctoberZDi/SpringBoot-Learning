package com.example.freemarkerdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * description: FreeMarkerController <br>
 * date: 2020/1/8 11:13 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */

@Controller
@RequestMapping(value = "fm")
public class FreeMarkerController {

    @RequestMapping(value = "hello")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");

        List<String> users = new ArrayList<String>();
        users.add("111");
        users.add("222");
        users.add("333");
        users.add("444");
        users.add("555");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
