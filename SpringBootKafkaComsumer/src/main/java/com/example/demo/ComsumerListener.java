package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

@Component
public class ComsumerListener {

    @KafkaListener(topics = {"demo_topic"}, containerFactory = "CustomizerFactory")
    public void listenerMessage(ConsumerRecord<String,String> record)
    {
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.topic());
    }
}
