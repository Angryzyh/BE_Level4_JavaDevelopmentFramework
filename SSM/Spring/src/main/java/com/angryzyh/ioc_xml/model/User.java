package com.angryzyh.ioc_xml.model;

import java.util.Objects;

public class User {
    private int uid;
    private String uname;
    private int age;

    static {
        System.out.println("静态构造代码块，类被加载啦！！！");
    }

    public User() {
        System.out.println("无参构造方法，对象诞生啦！！！");
    }

    public User(String uname, int age) {
        System.out.println("有参(无id)构造方法，对象诞生啦！！！");
        this.uname = uname;
        this.age = age;
    }

    public User(int uid, String uname, int age) {
        System.out.println("有参构造方法，对象诞生啦！！！");
        this.uid = uid;
        this.uname = uname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid == user.uid && age == user.age && Objects.equals(uname, user.uname);
    }
/*
    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, age);
    }*/

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
