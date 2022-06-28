package com.angryzyh.jdbctemplate.bean;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Bean {
    private Integer beanId;
    private String beanName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bean bean = (Bean) o;
        return Objects.equals(beanId, bean.beanId) && Objects.equals(beanName, bean.beanName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beanId, beanName);
    }

    @Override
    public String toString() {
        return "Bean{" +
                "beanId=" + beanId +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    public Integer getBeanId() {
        return beanId;
    }

    public void setBeanId(Integer beanId) {
        this.beanId = beanId;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
