package com.angryzyh.jdbctemplate.dao.impl;

import com.angryzyh.jdbctemplate.bean.Bean;
import com.angryzyh.jdbctemplate.dao.BeanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeanDaoImpl implements BeanDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addBean(Bean bean) {
        String sql = "insert into ssm_spring5_bean values(null,?)";
        Object[] args = {bean.getBeanName()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateBean(Bean bean) {
        String sql = "update ssm_spring5_bean set bean_name=? where bean_id=?";
        Object[] args = {bean.getBeanName(),bean.getBeanId()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int deleteBean(Bean bean) {
        String sql = "delete from ssm_spring5_bean where bean_id=?";
        Object[] args = {bean.getBeanId()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int totalNumber() {
        String sql = "select count(*) from ssm_spring5_bean";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public Bean queryOne(Integer id) {
        String sql = "select * from ssm_spring5_bean where bean_id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Bean>(Bean.class), id);
    }

    @Override
    public List<Bean> queryAll() {
        String sql = "select * from ssm_spring5_bean";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Bean>(Bean.class));
    }

    @Override
    public int[] batchAddBean(List<Object[]> batchArgs) {
        String sql = "insert into ssm_spring5_bean values(null,?)";
        return jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @Override
    public int[] batchUpdateBean(List<Object[]> batchArgs) {
        String sql = "update ssm_spring5_bean set bean_name=? where bean_id=?";
        return jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @Override
    public int[] batchDeleteBean(List<Object[]> batchArgs) {
        String sql = "delete from ssm_spring5_bean where bean_id=?";
        return jdbcTemplate.batchUpdate(sql, batchArgs);
    }
}
