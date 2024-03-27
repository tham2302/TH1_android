package com.lesson8.tablayout_viewpager_crud.model;

public class Cat {
    private int img;
    private String name;
    private double price;
    private String describe;

    public Cat() {
    }

    public Cat(int img, String name, double price, String describe) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.describe = describe;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
