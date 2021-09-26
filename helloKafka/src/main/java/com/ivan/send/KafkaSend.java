package com.ivan.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author hylu.ivan
 * @date 2021/9/25 下午9:51
 * @description
 */
@Component
public class KafkaSend {

    private static final Logger logger = LoggerFactory.getLogger(KafkaSend.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, List<String> messages) {
        for (String message : messages) {
            send(topic, message);
        }
    }

    public boolean send(String topic, String message) {
        boolean success = true;
        try {
            kafkaTemplate.send(topic, message).get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            success = false;
            logger.error("发送kafka失败, topic: {}, message: {}", topic, message, e);
        }
        return success;
    }
}