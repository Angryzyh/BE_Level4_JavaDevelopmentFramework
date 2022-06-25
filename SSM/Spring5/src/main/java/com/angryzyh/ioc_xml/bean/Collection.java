package com.angryzyh.ioc_xml.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collection {
    private String[] array;
    private List<Object> list;
    private Map<String, String> map;
    private Set<Object> set;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                '}';
    }
}
