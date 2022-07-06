package com.angryzyh.model;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private Integer empId;
    private String empName;
    private Integer empAge;
    private String empSex;
    private String empEmail;
    private Department dept;

    public Employee() {
    }

    public Employee(String empName, Integer empAge, String empSex, String empEmail) {
        this.empName = empName;
        this.empAge = empAge;
        this.empSex = empSex;
        this.empEmail = empEmail;
    }

    public Employee(Integer empId, String empName, Integer empAge, String empSex, String empEmail) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empSex = empSex;
        this.empEmail = empEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(empId, employee.empId) && Objects.equals(empName, employee.empName) && Objects.equals(empAge, employee.empAge) && Objects.equals(empSex, employee.empSex) && Objects.equals(empEmail, employee.empEmail) && Objects.equals(dept, employee.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empAge, empSex, empEmail, dept);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empSex='" + empSex + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
