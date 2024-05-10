package com.example.kt2_bottomnavigation.model;

import java.io.Serializable;

public class ItemDanhSach implements Serializable {
    private int id;
    private String ten,tacgia,ngay,nhaxuatban;

    private int gia;

    public ItemDanhSach() {
    }

    public ItemDanhSach(int id, String ten, String tacgia, String ngay, String nhaxuatban, int gia) {
        this.id = id;
        this.ten = ten;
        this.tacgia = tacgia;
        this.ngay = ngay;
        this.nhaxuatban = nhaxuatban;
        this.gia = gia;
    }

    public ItemDanhSach(String ten, String tacgia, String ngay, String nhaxuatban, int gia) {
        this.ten = ten;
        this.tacgia = tacgia;
        this.ngay = ngay;
        this.nhaxuatban = nhaxuatban;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(String nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
