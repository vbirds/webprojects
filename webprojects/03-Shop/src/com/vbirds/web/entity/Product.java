package com.vbirds.web.entity;

/**
 * Created by vbirds on 17-4-6.
 */
public class Product {
    private String id;
    private String name;
    private String proType;
    private double price;

    public Product(String id, String name, String proType, double price) {
        this.id = id;
        this.name = name;
        this.proType = proType;
        this.price = price;
    }

    public Product() {}

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", proType='" + proType + '\'' +
                ", price=" + price +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
