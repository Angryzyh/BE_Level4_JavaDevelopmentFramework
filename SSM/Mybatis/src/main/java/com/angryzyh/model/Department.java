package com.angryzyh.model;

import java.util.List;
import java.util.Objects;

public class Department {
    private Integer deptId;
    private String deptName;
    private List<Employee> emps;

    public Department() {
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Department(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(deptId, that.deptId) && Objects.equals(deptName, that.deptName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName);
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }
}
