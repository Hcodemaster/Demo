package com.example.demo.KafkaConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class kafakConfig {
    @Autowired
    ConsumerFactory<String,String> consumerFactory;

    @Bean(name = "CustomizerFactory")
    public ConcurrentKafkaListenerContainerFactory containerFactory()
    {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory);
        factory.setAckDiscarded(false);
        factory.setRecordFilterStrategy(consumerRecord -> {
            if(consumerRecord.offset() % 2 == 0)
                return false;
            return  true;
        });
        return factory;
    }

}
