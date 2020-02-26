package com.model;

public class Product {

    private String name;
    private double price;
    private String category;
    private int units;


    public Product(final String name, final double price, final String category, final int units) {
        super();
        this.name = name;
        this.price = price;
        this.category = category;
        this.units = units;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public int getUnits() {
        return this.units;
    }

    public void setUnits(final int units) {
        this.units = units;
    }


}
