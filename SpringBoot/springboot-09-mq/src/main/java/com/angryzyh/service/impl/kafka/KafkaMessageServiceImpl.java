package com.angryzyh.service.impl.kafka;

import com.angryzyh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageServiceImpl implements MessageService {

    @Autowired
    @SuppressWarnings("all")
    private KafkaTemplate kafkaTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送的短信订单已经纳入RabbitMQ处理队列,id=" + id);
        kafkaTemplate.send("topic_order",  id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
