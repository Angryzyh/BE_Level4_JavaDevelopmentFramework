package com.angryzyh.service.impl;

import com.angryzyh.service.MessageService;
import com.angryzyh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MessageService messageService;

    @Override
    public void order(String id) {
        System.out.println("↘-----------------------------------------------------↙");
        System.out.println("|order订单开始处理:" + id);
        messageService.sendMessage(id);
        System.out.println("|order订单处理结束:" + id);
        System.out.println("↗-----------------------------------------------------↖");
    }
}
