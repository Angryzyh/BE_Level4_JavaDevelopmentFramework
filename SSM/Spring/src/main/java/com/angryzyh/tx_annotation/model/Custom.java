package com.angryzyh.tx_annotation.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
//bean容器调用生成多例对象
@Scope("prototype")
public class Custom {
    private int cID;
    private String cName;
    private int cMoney;

    public Custom() {
    }
    public Custom(String cName, int cMoney) {
        this.cName = cName;
        this.cMoney = cMoney;
    }
    public Custom(int cID, String cName, int cMoney) {
        this.cID = cID;
        this.cName = cName;
        this.cMoney = cMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Custom custom = (Custom) o;
        return cID == custom.cID && cMoney == custom.cMoney && Objects.equals(cName, custom.cName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cID, cName, cMoney);
    }

    @Override
    public String toString() {
        return "Custom{" +
                "cID=" + cID +
                ", cName='" + cName + '\'' +
                ", cMoney=" + cMoney +
                '}';
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcMoney() {
        return cMoney;
    }

    public void setcMoney(int cMoney) {
        this.cMoney = cMoney;
    }
}
