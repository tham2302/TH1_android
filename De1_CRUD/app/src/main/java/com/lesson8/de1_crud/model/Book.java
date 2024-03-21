package com.lesson8.de1_crud.model;

public class Book {
    private String tenSach, tacGia, ngayXuatBan;
    private boolean khoaHoc, tieuThuyet, thieuNhi;

    public Book() {
    }

    public Book(String tenSach, String tacGia, String ngayXuatBan, boolean khoaHoc, boolean tieuThuyet, boolean thieuNhi) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.ngayXuatBan = ngayXuatBan;
        this.khoaHoc = khoaHoc;
        this.tieuThuyet = tieuThuyet;
        this.thieuNhi = thieuNhi;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(String ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public boolean isKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(boolean khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public boolean isTieuThuyet() {
        return tieuThuyet;
    }

    public void setTieuThuyet(boolean tieuThuyet) {
        this.tieuThuyet = tieuThuyet;
    }

    public boolean isThieuNhi() {
        return thieuNhi;
    }

    public void setThieuNhi(boolean thieuNhi) {
        this.thieuNhi = thieuNhi;
    }
}
