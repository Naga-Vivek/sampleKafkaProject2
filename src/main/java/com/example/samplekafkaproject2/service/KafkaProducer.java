package com.example.samplekafkaproject2.service;


import com.example.samplekafkaproject2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user){

        /*Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "json-topic")
                .build();

        kafkaTemplate.send(message);*/

        //OR
        kafkaTemplate.send("json-topic",user);
    }
}