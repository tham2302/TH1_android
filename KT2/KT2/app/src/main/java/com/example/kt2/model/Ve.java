package com.example.kt2.model;

import java.io.Serializable;

public class Ve implements Serializable {
    private int id;
    private String hoTen, noiKhoiHanh, ngayKhoiHanh;
    private boolean kyGui, thuoc, an, caphe;

    public Ve() {
    }

    public Ve(int id, String hoTen, String noiKhoiHanh, String ngayKhoiHanh, boolean kyGui, boolean thuoc, boolean an, boolean caphe) {
        this.id = id;
        this.hoTen = hoTen;
        this.noiKhoiHanh = noiKhoiHanh;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.kyGui = kyGui;
        this.thuoc = thuoc;
        this.an = an;
        this.caphe = caphe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNoiKhoiHanh() {
        return noiKhoiHanh;
    }

    public void setNoiKhoiHanh(String noiKhoiHanh) {
        this.noiKhoiHanh = noiKhoiHanh;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public boolean isKyGui() {
        return kyGui;
    }

    public void setKyGui(boolean kyGui) {
        this.kyGui = kyGui;
    }

    public boolean isThuoc() {
        return thuoc;
    }

    public void setThuoc(boolean thuoc) {
        this.thuoc = thuoc;
    }

    public boolean isAn() {
        return an;
    }

    public void setAn(boolean an) {
        this.an = an;
    }

    public boolean isCaphe() {
        return caphe;
    }

    public void setCaphe(boolean caphe) {
        this.caphe = caphe;
    }
}
