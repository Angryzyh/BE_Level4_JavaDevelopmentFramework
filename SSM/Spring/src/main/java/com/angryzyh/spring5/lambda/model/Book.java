package com.angryzyh.spring5.lambda.model;

import java.util.Objects;

public class Book {
    private Integer bid;
    private String bname;

    public Book() {
    }
    public Book(String bname) {
        this.bname = bname;
    }
    public Book(Integer bid, String bname) {
        this.bid = bid;
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bid, book.bid) && Objects.equals(bname, book.bname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bid, bname);
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
