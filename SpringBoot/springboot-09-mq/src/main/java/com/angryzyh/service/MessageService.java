package com.angryzyh.service;

public interface MessageService {
    //分发请求
    void sendMessage(String id);

    //处理请求
    String doMessage();
}
