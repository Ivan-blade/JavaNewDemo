package com.ivan.listener;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hylu.ivan
 * @date 2021/9/25 下午9:29
 * @description
 */
@Component
public class MyKafkaListener {

    // id可以设置kafka消费者线程名，不设置也没事
    @KafkaListener(
            id = "kafkaListener",
            topics = "#{'${spring.kafka.consumer.topics}'.split(',')}",
            autoStartup = "${spring.kafka.consumer.autoStartup}",
            containerFactory = "kafkaListenerContainerFactory")
    public void listen(List<ConsumerRecord<String, String>> records, Consumer<?, ?> consumer) {

        for (ConsumerRecord<String, String> record : records) {
            String value = record.value();
            System.out.println(value);
        }
        consumer.commitSync();
    }
}