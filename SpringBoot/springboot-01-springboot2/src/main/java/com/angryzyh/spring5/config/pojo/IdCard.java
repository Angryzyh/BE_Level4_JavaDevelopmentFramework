package com.angryzyh.spring5.config.pojo;

public class IdCard {
    private String idNum;
    private User Holder;

    public IdCard() {
    }

    public IdCard(User holder) {
        Holder = holder;
    }

    public IdCard(String idNum, User holder) {
        this.idNum = idNum;
        Holder = holder;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "idNum='" + idNum + '\'' +
                ", Holder=" + Holder +
                '}';
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public User getHolder() {
        return Holder;
    }

    public void setHolder(User holder) {
        Holder = holder;
    }
}
