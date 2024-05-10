package com.example.kt2_tablayout.model;

import java.io.Serializable;

public class ItemThongTin implements Serializable {
    private int id;
    private String anh,ten,nhanxet;

    public ItemThongTin() {
    }

    public ItemThongTin(String anh, String ten, String nhanxet) {
        this.anh = anh;
        this.ten = ten;
        this.nhanxet = nhanxet;
    }

    public ItemThongTin(int id, String anh, String ten, String nhanxet) {
        this.id = id;
        this.anh = anh;
        this.ten = ten;
        this.nhanxet = nhanxet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNhanxet() {
        return nhanxet;
    }

    public void setNhanxet(String nhanxet) {
        this.nhanxet = nhanxet;
    }
}
