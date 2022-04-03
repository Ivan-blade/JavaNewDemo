package com.ivan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author hylu.ivan
 * @date 2022/4/3 下午8:29
 * @description
 */

@RestController
@ResponseBody
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("/put")
    public String putData(@RequestParam(required = true) String key,
                          @RequestParam(required = true) String value) {
        // 放入一个有效时间为60秒的数据
        redisTemplate.opsForValue().set(key,value,60, TimeUnit.SECONDS);
        return "success";
    }

    @GetMapping("/get")
    public String get(@RequestParam(required = true) String key) {
        return String.valueOf(redisTemplate.opsForValue().get(key));
    }
}
