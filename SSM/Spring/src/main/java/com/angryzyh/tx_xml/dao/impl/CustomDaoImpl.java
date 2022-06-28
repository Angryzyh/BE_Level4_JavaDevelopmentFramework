package com.angryzyh.tx_xml.dao.impl;

import com.angryzyh.tx_xml.bean.Custom;
import com.angryzyh.tx_xml.dao.CustomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomDaoImpl implements CustomDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //加钱
    @Override
    public void addMoney(Custom custom,Integer money) {
        String sql = "update ssm_spring_custom set c_money=c_money+? where c_name=?";
        Object[] args = {money,custom.getcName()};
        jdbcTemplate.update(sql, args);
    }

    //减钱
    @Override
    public void reduceMoney(Custom custom,Integer money) {
        String sql = "update ssm_spring_custom set c_money=c_money-? where c_name=?";
        Object[] args = {money,custom.getcName()};
        jdbcTemplate.update(sql, args);
    }
}
