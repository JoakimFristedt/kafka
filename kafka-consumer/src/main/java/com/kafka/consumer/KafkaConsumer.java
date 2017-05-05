package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
    private final CountDownLatch latch;

    public KafkaConsumer() {
        this.latch = new CountDownLatch(1);
    }

    @KafkaListener(topics = "add")
    public void add(ConsumerRecord<String, String> record) {
        log.info("Add: {}={}", record.key(), record.value());
    }

    @KafkaListener(topics = "delete")
    public void delete(ConsumerRecord<String, String> record) {
        log.info("Delete: {}={}", record.key(), record.value());
    }

}
