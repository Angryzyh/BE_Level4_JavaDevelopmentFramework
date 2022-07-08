package com.angryzyh.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration  //声明类配置文件
@PropertySource("classpath:jdbc.properties") //导入外部属性配置文件
@EnableAspectJAutoProxy(proxyTargetClass = true) //开启aop注解
@EnableTransactionManagement(proxyTargetClass = true) //开启事务,并采采用cglib代理
@MapperScan("com.angryzyh.mapper")  //自动扫描mapper包
@ComponentScan(basePackages = {"com.angryzyh"},excludeFilters ={
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)
}) //开启组件扫描 , 主要扫描service层和dao层.排除controller层
public class SpringConfig {

    @Value(value = "${jdbc.driverClassName}")
    private String driverClassName;
    @Value(value = "${jdbc.url}")
    private String url;
    @Value(value = "${jdbc.username}")
    private String username;
    @Value(value = "${jdbc.password}")
    private String password;

    //创建数据库连接池
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    // 创建事务管理器
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("getDruidDataSource") DataSource druidDataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(druidDataSource);
        return transactionManager;
    }

    //创建SqlSessionFactory Bean容器
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(getDruidDataSource());
        return factoryBean.getObject();
    }

   /* //创建jdbcTemplate对象
    @Bean
    public JdbcTemplate getJdbcTemplate(@Qualifier("getDruidDataSource") DataSource druidDataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
        return jdbcTemplate;
    }*/

}
