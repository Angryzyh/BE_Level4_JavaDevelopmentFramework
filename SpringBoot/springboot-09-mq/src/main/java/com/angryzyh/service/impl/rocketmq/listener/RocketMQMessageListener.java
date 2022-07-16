package com.angryzyh.service.impl.rocketmq.listener;

import org.apache.rocketmq.spring.core.RocketMQListener;


//@Component
//@org.apache.rocketmq.spring.annotation.RocketMQMessageListener( topic = "order_id",consumerGroup = "group_1")
public class RocketMQMessageListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String id) {
        System.out.println("RocketMQ-q1-1已完成短信发送业务,id：" + id);
    }
}
