package com.angryzyh.tx_xml.service.impl;

import com.angryzyh.tx_xml.model.Custom;
import com.angryzyh.tx_xml.dao.CustomDao;
import com.angryzyh.tx_xml.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    private CustomDao customDao;

    //转账
    @Override
    public void transferMoney(Custom add_custom, Custom reduce_custom, Integer money) {
        customDao.reduceMoney(reduce_custom, money);
        //模拟异常
        int i = 10 / 0;
        customDao.addMoney(add_custom, money);
    }
}
