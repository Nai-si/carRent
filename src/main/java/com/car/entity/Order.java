package com.car.entity;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 16:37
 * @Description: 订单列表的实体类
 */
public class Order {

    private int id;
    private int cid;
    private int uid;
    private int getid;
    private int backid;
    private double oprice;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGetid() {
        return getid;
    }

    public void setGetid(int getid) {
        this.getid = getid;
    }

    public int getBackid() {
        return backid;
    }

    public void setBackid(int backid) {
        this.backid = backid;
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
