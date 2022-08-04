import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Producer {
    public static String topic = "demo_topic";
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(properties);
        for(int i=0;i<3;i++)
        {
            String msg = "Hello World " + String.valueOf(i) + "!";
            ProducerRecord<String,String> record = new ProducerRecord<String, String>(topic,msg);
            RecordMetadata recordMetadata = kafkaProducer.send(record).get();
            System.out.println(recordMetadata.partition());
            System.out.println(recordMetadata.offset());
        }
        kafkaProducer.close();
    }
}
