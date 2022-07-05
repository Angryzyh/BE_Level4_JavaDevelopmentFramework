package com.angryzyh.jdbctemplate.dao;

import com.angryzyh.jdbctemplate.model.Bean;

import java.util.List;

public interface BeanDao {
    //添加
    int addBean(Bean bean);

    //修改
    int updateBean(Bean bean);

    //删除
    int deleteBean(Bean bean);

    //查询总数
    int totalNumber();

    //查询单个结果,返回结果对象
    Bean queryOne(Integer id);

    //查询全部结果，返回结果为对象集合
    List<Bean> queryAll();

    //批量添加
    int[] batchAddBean(List<Object[]> batchArgs);

    //批量修改
    int[] batchUpdateBean(List<Object[]> batchArgs);

    //批量删除
    int[] batchDeleteBean(List<Object[]> batchArgs);

}
