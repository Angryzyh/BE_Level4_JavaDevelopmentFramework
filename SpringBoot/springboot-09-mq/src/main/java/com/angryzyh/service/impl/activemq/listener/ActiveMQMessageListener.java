package com.angryzyh.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

//@Component
public class ActiveMQMessageListener {
    @JmsListener(destination = "order.msg.queue.id")
    @SendTo("order.other.queue.id")
    public String receive(String id) {
        System.out.println("ActiveMQ已完成短信发送业务，id：" + id);
        return "new:" + id;
    }
}
