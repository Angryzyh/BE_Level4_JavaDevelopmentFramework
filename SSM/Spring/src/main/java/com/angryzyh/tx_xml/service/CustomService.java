package com.angryzyh.tx_xml.service;

import com.angryzyh.tx_xml.bean.Custom;

public interface CustomService {
    //转账
    public void transferMoney(Custom add_custom ,Custom reduce_custom,Integer money);
}
