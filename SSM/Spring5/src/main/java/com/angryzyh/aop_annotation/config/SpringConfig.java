package com.angryzyh.aop_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.angryzyh.aop_annotation"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {
}
