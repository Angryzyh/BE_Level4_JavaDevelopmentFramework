package com.angryzyh.spring5.junit.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Booker {
    @Value(value = "1")
    private Integer bid;
    @Value(value = "《spring葵花宝典》")
    private String bname;

    @Override
    public String toString() {
        return "Booker{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
