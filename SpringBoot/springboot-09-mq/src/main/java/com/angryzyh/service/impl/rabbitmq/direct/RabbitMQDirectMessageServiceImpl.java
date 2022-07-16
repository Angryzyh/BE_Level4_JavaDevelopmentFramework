package com.angryzyh.service.impl.rabbitmq.direct;

import com.angryzyh.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class RabbitMQDirectMessageServiceImpl implements MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送的短信订单已经纳入RabbitMQ处理队列,id=" + id);
        amqpTemplate.convertAndSend("directExchange", "direct11", id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
