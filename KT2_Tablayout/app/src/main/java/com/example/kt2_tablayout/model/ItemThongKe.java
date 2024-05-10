package com.example.kt2_tablayout.model;

import java.io.Serializable;

public class ItemThongKe implements Serializable {
    private String name;
    int sl;

    public ItemThongKe(String name, int sl) {
        this.name = name;
        this.sl = sl;
    }

    public ItemThongKe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
}
