package com.angryzyh.service.impl.activemq;

import com.angryzyh.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

//@Service
public class ActiveMQMessageServiceImpl implements MessageService {

    @Autowired
    @SuppressWarnings("all")
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送的短信订单已经纳入ActiveMQ处理队列,id=" + id);
        jmsMessagingTemplate.convertAndSend("order.msg.queue.id",id); //指定队列 坐标key  用于监听器监听指定key
    }

    @Override
    public String doMessage() {
        String id = jmsMessagingTemplate.receiveAndConvert(String.class);
        System.out.println("已完成短信发送业务,id = " + id);
        return id;
    }
}
