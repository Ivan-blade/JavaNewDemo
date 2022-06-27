package com.ivan.utils;

import com.ivan.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author hylu.ivan
 * @date 2022/6/27 下午9:50
 * @description
 */
public class RestUtilsTest extends BaseTest {


    @Autowired
    private RestUtils restUtils;

    @Test
    public void doGet() {

        String s = restUtils.doGet("https://weibo.com/ajax/statuses/mymblog?uid=1259110474&page=1&feature=0");
        System.out.println(s);
    }

    @Test
    public void doPost() {

        String s = restUtils.doPost("https://passport.weibo.com/visitor/genvisitor");
        System.out.println(s);
    }
}