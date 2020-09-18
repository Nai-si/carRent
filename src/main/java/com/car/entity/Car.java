package com.car.entity;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 15:27
 * @Description:
 */
public class Car {

    private int id;
    private String name;
    private String type;
    private int sitnum;
    private int cid;
    private Double price;
    private int number;
    private String picture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSitnum() {
        return sitnum;
    }

    public void setSitnum(int sitnum) {
        this.sitnum = sitnum;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
