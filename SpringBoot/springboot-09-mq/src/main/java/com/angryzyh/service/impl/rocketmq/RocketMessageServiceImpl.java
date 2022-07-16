package com.angryzyh.service.impl.rocketmq;

import com.angryzyh.service.MessageService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class RocketMessageServiceImpl implements MessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送的短信订单已经纳入RocketMQ处理队列,id=" + id);
        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("消息发送失败");
            }
        };
        rocketMQTemplate.asyncSend("order_id",id,callback); 
    }

    @Override
    public String doMessage() {
        return null;
    }
}
