package com.nure.bearer.Adapter;

public class Cell {

    private String status = "";
    private String tmp = "";
    private double price = -1d;
    private String shelfLife = "";
    private String foodName = "";;
    private int number = -1;
    private int id = -1;
    private double weight = -1d;

    public Cell(String status,String tmp, double price, String foodName, int number, int id, double weight) {
        this.status = status;
        this.tmp = tmp;
        this.price = price;
        this.foodName = foodName;
        this.number = number;
        this.id = id;
        this.weight = weight;
    }

    public Cell(String status, int number, int id) {
        this.status = status;
        this.number = number;
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "status='" + status + '\'' +
                ", tmp='" + tmp + '\'' +
                ", price=" + price +
                ", shelfLife='" + shelfLife + '\'' +
                ", foodName='" + foodName + '\'' +
                ", number=" + number +
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }
}
