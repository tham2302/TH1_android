package com.lesson8.tichhop.model;

public class Book {
    private String tenSach, ngayXuatBan, gioSinh;
    private boolean laNam;
    private String trinhDo;
    private boolean intern, fresher, junior, senior;

    public Book() {
    }

    public Book(String tenSach, String ngayXuatBan, String gioSinh, boolean laNam, String trinhDo, boolean intern, boolean fresher, boolean junior, boolean senior) {
        this.tenSach = tenSach;
        this.ngayXuatBan = ngayXuatBan;
        this.gioSinh = gioSinh;
        this.laNam = laNam;
        this.trinhDo = trinhDo;
        this.intern = intern;
        this.fresher = fresher;
        this.junior = junior;
        this.senior = senior;
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

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public boolean isIntern() {
        return intern;
    }

    public void setIntern(boolean intern) {
        this.intern = intern;
    }

    public boolean isFresher() {
        return fresher;
    }

    public void setFresher(boolean fresher) {
        this.fresher = fresher;
    }

    public boolean isJunior() {
        return junior;
    }

    public void setJunior(boolean junior) {
        this.junior = junior;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }
}
