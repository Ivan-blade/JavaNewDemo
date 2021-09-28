package com.ivan.controller;

import com.ivan.service.CommonService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hylu.ivan
 * @date 2021/9/27 下午10:51
 * @description
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Reference
    private CommonService commonService;

    @RequestMapping("/hello")
    public String hello(String str) {
        return commonService.hello(str);
    }
}
