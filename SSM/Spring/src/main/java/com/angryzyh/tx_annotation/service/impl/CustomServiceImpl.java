package com.angryzyh.tx_annotation.service.impl;

import com.angryzyh.tx_annotation.bean.Custom;
import com.angryzyh.tx_annotation.dao.CustomDao;
import com.angryzyh.tx_annotation.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
