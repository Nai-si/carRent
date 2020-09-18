package com.car.entity;

/**
 * @ProjectName: carRent
 * @Author: Jsx
 * @Time: 2020/9/18 23:03
 * @Description:
 */
public class OrderTwo {
    private int id;
    private double oprice;
    private String name;
    private String getCar;
    private String backCar;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getOprice() {
        return oprice;
    }

    public void setOprice(double oprice) {
        this.oprice = oprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGetCar() {
        return getCar;
    }

    public void setGetCar(String getCar) {
        this.getCar = getCar;
    }

    public String getBackCar() {
        return backCar;
    }

    public void setBackCar(String backCar) {
        this.backCar = backCar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderTwo{" +
                "id=" + id +
                ", oprice=" + oprice +
                ", name='" + name + '\'' +
                ", getCar='" + getCar + '\'' +
                ", backCar='" + backCar + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
