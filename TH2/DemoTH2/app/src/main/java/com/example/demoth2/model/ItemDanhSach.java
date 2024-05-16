package com.example.demoth2.model;

import java.io.Serializable;

public class ItemDanhSach implements Serializable {
    private int id;
    private String ten,tacgia, nxb, gio;

    //private int gia;
    private boolean isHoc, isTC;
    private boolean isCNTT, isVT, isDT;
    private int rating;
    private int gia;

    public ItemDanhSach() {
    }

    public ItemDanhSach(int id, String ten, String tacgia, String nxb, String gio, boolean isHoc, boolean isTC, boolean isCNTT, boolean isVT, boolean isDT, int rating, int gia) {
        this.id = id;
        this.ten = ten;
        this.tacgia = tacgia;
        this.nxb = nxb;
        this.gio = gio;
        this.isHoc = isHoc;
        this.isTC = isTC;
        this.isCNTT = isCNTT;
        this.isVT = isVT;
        this.isDT = isDT;
        this.rating = rating;
        this.gia = gia;
    }

    public ItemDanhSach(String ten, String tacgia, String nxb, String gio, boolean isHoc, boolean isTC, boolean isCNTT, boolean isVT, boolean isDT, int rating, int gia) {
        this.ten = ten;
        this.tacgia = tacgia;
        this.nxb = nxb;
        this.gio = gio;
        this.isHoc = isHoc;
        this.isTC = isTC;
        this.isCNTT = isCNTT;
        this.isVT = isVT;
        this.isDT = isDT;
        this.rating = rating;
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

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public boolean isHoc() {
        return isHoc;
    }

    public void setHoc(boolean hoc) {
        isHoc = hoc;
    }

    public boolean isTC() {
        return isTC;
    }

    public void setTC(boolean TC) {
        isTC = TC;
    }

    public boolean isCNTT() {
        return isCNTT;
    }

    public void setCNTT(boolean CNTT) {
        isCNTT = CNTT;
    }

    public boolean isVT() {
        return isVT;
    }

    public void setVT(boolean VT) {
        isVT = VT;
    }

    public boolean isDT() {
        return isDT;
    }

    public void setDT(boolean DT) {
        isDT = DT;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
