package com.example.samplekafkaproject2.service;

import com.example.samplekafkaproject2.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "json-topic" ,
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user){
        System.out.println("Json message consumed : "+ user);
    }
}