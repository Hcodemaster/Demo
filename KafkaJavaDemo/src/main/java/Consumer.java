import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


import java.util.Collections;
import java.util.Properties;

public class Consumer {

    public static void main(String[] args)
    {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"demo_topic");
        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(Collections.singletonList(Producer.topic));
        while (true)
        {
            ConsumerRecords<String,String> records = kafkaConsumer.poll(1000);
            System.out.println("get message length " + records.count());
            for(ConsumerRecord record:records)
            {
                System.out.println(String.format("topic:%s,offset:%d,消息:%s",record.topic(),record.offset(),record.value()));
            }

        }
    }
}
