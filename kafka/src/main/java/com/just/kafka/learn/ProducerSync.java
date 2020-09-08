package com.just.kafka.learn;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @description:KafkaProducer
 * @author: Peng.Li
 * @create: 2020-02-19 16:20
 **/
@Slf4j
public class ProducerSync {

    private static final String BROKER_LIST = "localhost:9092";

    private static final String TOPIC = "topic-demo";


    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        return properties;
    }

    public  static void main(String[] args) {
        Properties properties = initConfig();
        KafkaProducer<String, String> producer = new KafkaProducer(properties);
        //消息
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, "hello,kafka");
        try {
            producer.send(record).get();
        } catch (Exception e) {
            log.error("异常", e);
        }
        producer.close();
    }
}
