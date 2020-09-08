package com.just.kafka.learn;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @description:KafkaProducer
 * @author: Peng.Li
 * @create: 2020-02-19 16:20
 **/
@Slf4j
public class ProducerAsync {

    private static final String BROKER_LIST = "localhost:9092";

    private static final String TOPIC = "topic-demo";


    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, ProducerInterceptor.class.getName() + "," + "xxx");
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = initConfig();
        KafkaProducer<String, String> producer = new KafkaProducer(properties);
        //消息
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, "hello,kafka");
        try {
            Future<RecordMetadata> future = producer.send(record,(recordMetadata,e)->{
                if (e != null) {
                    log.error("发生异常", e);
                }else {
                    //do something
                }
            });
            RecordMetadata recordMetadata = future.get();
            log.info("topic:{},partition:{},offset:{}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
        } catch (Exception e) {
            log.error("异常", e);
        }
        producer.close();
    }


}
