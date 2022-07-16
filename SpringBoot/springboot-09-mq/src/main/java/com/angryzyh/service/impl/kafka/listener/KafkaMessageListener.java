package com.angryzyh.service.impl.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

//@Component
public class KafkaMessageListener {

    /*
    * 绑定了同一个消息队列,用两个监听器去消费,结果轮流执行
    * */

    @KafkaListener(topics = {"kafka_topic"})
    public void receive(ConsumerRecord<?,?>  record) {
        System.out.println("Kafka已完成短信发送业务,id：" + record.value());
    }

}
