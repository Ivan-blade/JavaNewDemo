package com.ivan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @author hylu.ivan
 * @date 2021/9/25 下午5:03
 * @description
 */
@SpringBootApplication
@EnableKafka
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }
}
