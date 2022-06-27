package com.angryzyh.jdbctemplate.service.impl;

import com.angryzyh.jdbctemplate.bean.Bean;
import com.angryzyh.jdbctemplate.dao.BeanDao;
import com.angryzyh.jdbctemplate.service.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeanServiceImpl implements BeanService {
    @Autowired
    private BeanDao beanDao;

    @Override
    public int addBean(Bean bean) {
        return beanDao.addBean(bean);
    }

    @Override
    public int updateBean(Bean bean) {
        return beanDao.updateBean(bean);
    }

    @Override
    public int deleteBean(Bean bean) {
        return beanDao.deleteBean(bean);
    }

    @Override
    public int totalNumber() {
        return beanDao.totalNumber();
    }

    @Override
    public Bean queryOne(Integer id) {
        return beanDao.queryOne(id);
    }

    @Override
    public List<Bean> queryAll() {
        return beanDao.queryAll();
    }

    @Override
    public int[] batchAddBean(List<Object[]> batchArgs) {
        return beanDao.batchAddBean(batchArgs);
    }

    @Override
    public int[] batchUpdateBean(List<Object[]> batchArgs) {
        return beanDao.batchUpdateBean(batchArgs);
    }

    @Override
    public int[] batchDeleteBean(List<Object[]> batchArgs) {
        return beanDao.batchDeleteBean(batchArgs);
    }
}
