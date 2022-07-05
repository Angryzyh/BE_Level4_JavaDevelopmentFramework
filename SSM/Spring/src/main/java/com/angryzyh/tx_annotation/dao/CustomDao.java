package com.angryzyh.tx_annotation.dao;

import com.angryzyh.tx_annotation.model.Custom;

public interface CustomDao {
    //加钱
    public void addMoney(Custom custom,Integer money);

    //减钱
    public void reduceMoney(Custom custom,Integer money);

}
