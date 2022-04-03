package com.ivan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author hylu.ivan
 * @date 2022/4/3 下午6:21
 * @description
 */
@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }
}
