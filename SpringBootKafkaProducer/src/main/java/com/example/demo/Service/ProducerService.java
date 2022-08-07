package com.example.demo.Service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class ProducerService implements com.example.demo.Interface.ProducerService {
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;
    @Override
    public void sendMessage(String topic, String data) {
        //ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>(topic,0,System.currentTimeMillis(),"topic-key","测试");
        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(topic,data);
        listenableFuture.addCallback(success -> System.out.println("发送消息成功" + success.getRecordMetadata().partition() + " OFFSET = " + success.getRecordMetadata().offset() + " topic = " +success.getRecordMetadata().topic()),failure -> System.out.println("发送消息失败，失败原因是{}"+failure.getMessage()));
    }
}
