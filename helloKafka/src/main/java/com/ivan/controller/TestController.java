package com.ivan.controller;

import com.ivan.send.KafkaSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hylu.ivan
 * @date 2021/9/26 下午9:02
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private KafkaSend kafkaSend;


    @RequestMapping("/hello")
    public String test(String str) {
        boolean test = kafkaSend.send("test", str);
        return test == true ? "消息发送成功！" : "消息发送失败！";
    }
}
