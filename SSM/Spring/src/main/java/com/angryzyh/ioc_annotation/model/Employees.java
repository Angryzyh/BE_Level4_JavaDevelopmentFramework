package com.angryzyh.ioc_annotation.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employees {
    private int eid;
    private String ename;
    private double salary;
    @Autowired
    private Department department;

    public Employees() {
    }

    public Employees(String ename, double salary, Department department) {
        this.ename = ename;
        this.salary = salary;
        this.department = department;
    }

    public Employees(int eid, String ename, double salary, Department department) {
        this.eid = eid;
        this.ename = ename;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
