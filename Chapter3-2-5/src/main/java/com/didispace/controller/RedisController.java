package com.didispace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: RedisController <br>
 * date: 2019/12/26 16:56 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@RestController
public class RedisController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "testRedis")
    public Object testRedis() {
        stringRedisTemplate.opsForValue().set("name", "zhangdi");

        return stringRedisTemplate.opsForValue().get("name");
    }
}
