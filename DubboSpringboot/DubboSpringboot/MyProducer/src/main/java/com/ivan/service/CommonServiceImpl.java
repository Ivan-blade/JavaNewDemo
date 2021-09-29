package com.ivan.service;


import org.apache.dubbo.config.annotation.Service;

/**
 * @author hylu.ivan
 * @date 2021/9/27 下午10:48
 * @description
 */
@Service
public class CommonServiceImpl implements CommonService{

    @Override
    public String hello(String str) {
        return str;
    }
}
