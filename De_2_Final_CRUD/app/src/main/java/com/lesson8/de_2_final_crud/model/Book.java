package com.lesson8.de_2_final_crud.model;

public class Book {
    private String tenSach, ngayXuatBan;
    private boolean laNam;
    private boolean khoaHoc, tieuThuyet, thieuNhi;

    public Book() {
    }

    public Book(String tenSach, String ngayXuatBan, boolean laNam, boolean khoaHoc, boolean tieuThuyet, boolean thieuNhi) {
        this.tenSach = tenSach;
        this.ngayXuatBan = ngayXuatBan;
        this.laNam = laNam;
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

    public String getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(String ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    public boolean isLaNam() {
        return laNam;
    }

    public void setLaNam(boolean laNam) {
        this.laNam = laNam;
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
