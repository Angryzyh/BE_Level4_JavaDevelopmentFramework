package com.angryzyh.jdbctemplate.service;

import com.angryzyh.jdbctemplate.model.Bean;

import java.util.List;

public interface BeanService {
    //添加
    public int addBean(Bean bean);

    //修改
    public int updateBean(Bean bean);

    //删除
    public int deleteBean(Bean bean);

    //查询总数
    public int totalNumber();

    //查询单个结果,返回结果对象
    public Bean queryOne(Integer id);

    //查询全部结果，返回结果为对象集合
    public List<Bean> queryAll();

    //批量添加
    public int[] batchAddBean(List<Object[]> batchArgs);

    //批量修改
    public int[] batchUpdateBean(List<Object[]> batchArgs);

    //批量删除
    public int[] batchDeleteBean(List<Object[]> batchArgs);
}
