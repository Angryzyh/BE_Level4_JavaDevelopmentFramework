package com.angryzyh.ioc_annotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserByValue {
    @Value(value = "101")
    private int uid;
    @Value(value = "小米")
    private String uname;

    public UserByValue() {
    }

    public UserByValue(int uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "UserByValue{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
