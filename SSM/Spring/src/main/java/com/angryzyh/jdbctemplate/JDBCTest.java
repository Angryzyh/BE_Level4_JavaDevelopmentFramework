package com.angryzyh.jdbctemplate;

import com.angryzyh.jdbctemplate.bean.Bean;
import com.angryzyh.jdbctemplate.service.impl.BeanServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JDBCTest {
    ApplicationContext app = new ClassPathXmlApplicationContext("jdbc_template/ApplicationContext.xml");
    Bean bean = app.getBean("bean", Bean.class);
    BeanServiceImpl beanService = app.getBean("beanServiceImpl", BeanServiceImpl.class);
    //测试添加方法
    @Test
    public void addBean() {
        bean.setBeanName("小小b2");
        System.out.println("bean = " + bean);
        int i = beanService.addBean(bean);
        if (i > 0) {
            System.out.println("添加成功!!!");
            System.out.println("共计影响了:" + i+"条数据");
        }
    }

    //测试修改方法
    @Test
    public void updateBean() {
        bean.setBeanId(2);
        bean.setBeanName("改-小小b2");
        System.out.println("bean = " + bean);
        int i = beanService.updateBean(bean);
        if (i > 0) {
            System.out.println("修改成功!!!");
            System.out.println("共计影响了:" + i+"条数据");
        }
    }

    //测试删除方法
    @Test
    public void deleteBean() {
        bean.setBeanId(2);
        System.out.println("bean = " + bean);
        int i = beanService.deleteBean(bean);
        if (i > 0) {
            System.out.println("删除成功!!!");
            System.out.println("共计影响了:" + i+"条数据");
        }
    }

    //测试查询总数方法
    @Test
    public void totalNumber() {
        int i = beanService.totalNumber();
        if (i > 0) {
            System.out.println("查询成功!!!");
            System.out.println("共计:" + i+"条数据");
        }
    }

    //测试查询单个对象方法
    @Test
    public void queryOne() {
        Bean bean = beanService.queryOne(1);
        System.out.println("bean = " + bean);
    }

    //测试查询全部数据，返回集合对象
    @Test
    public void queryAll() {
        for (Bean bean : beanService.queryAll()) {
            System.out.println("bean = " + bean);
        }
    }

    //测试批量添加
    @Test
    public void batchAddBean() {
        List<Object[]> batchBeans = new ArrayList<>();
        Object[] bean1 = {"小明"};
        Object[] bean2 = {"小王"};
        Object[] bean3 = {"小红"};
        Collections.addAll(batchBeans, bean1, bean2, bean3);
        int[] ints = beanService.batchAddBean(batchBeans);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    //测试批量修改
    @Test
    public void batchUpdateBean() {
        List<Object[]> batchBeans = new ArrayList<>();
        Object[] bean1 = {"小明a",6};
        Object[] bean2 = {"小王b",7};
        Object[] bean3 = {"小红c",8};
        Collections.addAll(batchBeans, bean1, bean2, bean3);
        int[] ints = beanService.batchUpdateBean(batchBeans);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    //测试批量删除
    @Test
    public void batchDeleteBean() {
        List<Object[]> batchBeans = new ArrayList<>();
        Object[] bean1 = {6};
        Object[] bean2 = {7};
        Object[] bean3 = {8};
        Collections.addAll(batchBeans, bean1, bean2, bean3);
        int[] ints = beanService.batchDeleteBean(batchBeans);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
