package com.example.testdev.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: TestController <br>
 * date: 2019/12/26 10:44 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @RequestMapping("a")
    public String test() {
        return "aaaa";
    }
}
