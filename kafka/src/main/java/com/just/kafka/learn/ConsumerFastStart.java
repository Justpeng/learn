package com.just.kafka.learn;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2020-02-19 11:33
 **/
@Slf4j
public class ConsumerFastStart {

    private static final String BROKER_LIST = "localhost:9092";

    private static final String TOPIC = "topic-demo";

    private static final String GROUP = "group.demo";

    public static void main(String args[]) {
        Properties properties = new Properties();

        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("bootstrap.servers", BROKER_LIST);

        properties.put("group.id", GROUP);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        consumer.subscribe(Collections.singletonList(TOPIC));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                log.info("消息:{}",record.value());
            }
        }

    }
}
