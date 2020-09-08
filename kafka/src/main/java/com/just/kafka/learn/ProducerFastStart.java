package com.just.kafka.learn;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-02-19 11:20
 **/
@Slf4j
public class ProducerFastStart {
    private static final String BROKER_LIST = "localhost:9092";

    private static final String TOPIC = "topic-demo";

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("bootstrap.servers", BROKER_LIST);

        KafkaProducer<String, String> producer = new KafkaProducer(properties);

        //消息

        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, "hello,kafka");

        try {
            producer.send(record);
        } catch (Exception e) {
            log.error("异常", e);
        }

        producer.close();
    }

}
