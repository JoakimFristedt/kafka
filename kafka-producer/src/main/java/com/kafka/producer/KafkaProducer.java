package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestBody Item item) {
        kafkaTemplate.send("add", item.getKey(), item.getValue());
        return String.format("Added: %s", item.toString());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody Item item) {
        kafkaTemplate.send("delete", item.getKey(), item.getValue());
        return String.format("Delete: %s", item.toString());
    }

}
