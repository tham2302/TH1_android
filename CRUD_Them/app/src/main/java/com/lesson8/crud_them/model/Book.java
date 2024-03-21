package com.lesson8.crud_them.model;

public class Book {
    private String tenSach, ngayXuatBan, gioSinh;
    private boolean laNam;
    private String quocTich;

    public Book() {
    }

    public Book(String tenSach, String ngayXuatBan, String gioSinh, boolean laNam, String quocTich) {
        this.tenSach = tenSach;
        this.ngayXuatBan = ngayXuatBan;
        this.gioSinh = gioSinh;
        this.laNam = laNam;
        this.quocTich = quocTich;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(String ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public String getGioSinh() {
        return gioSinh;
    }

    public void setGioSinh(String gioSinh) {
        this.gioSinh = gioSinh;
    }

    public boolean isLaNam() {
        return laNam;
    }

    public void setLaNam(boolean laNam) {
        this.laNam = laNam;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }
}
