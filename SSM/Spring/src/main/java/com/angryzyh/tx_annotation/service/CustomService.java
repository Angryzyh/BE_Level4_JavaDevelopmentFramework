package com.angryzyh.tx_annotation.service;

import com.angryzyh.tx_annotation.bean.Custom;

public interface CustomService {
    //转账
    public void transferMoney(Custom add_custom ,Custom reduce_custom,Integer money);
}
