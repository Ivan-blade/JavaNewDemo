package com.ivan.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author hylu.ivan
 * @date 2021/9/25 下午9:23
 * @description
 */
@Data
@Configuration
public class KafkaOtherProperties {

    @Value("${spring.kafka.consumer.concurrency:3}")
    private int concurrency;

    @Value("${spring.kafka.bootstrap-servers:3}")
    private List<String> bootstrapServers;

}
