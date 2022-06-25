package com.angryzyh.ioc_xml.bean;

import java.util.Objects;

public class Department {
    private int did;
    private String dname;
    private String address;

    public Department() {
    }

    public Department(String dname, String address) {
        this.dname = dname;
        this.address = address;
    }

    public Department(int did, String dname, String address) {
        this.did = did;
        this.dname = dname;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return did == that.did && Objects.equals(dname, that.dname) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, dname, address);
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
