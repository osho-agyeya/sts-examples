
package com.model;

public class Product {

    private int id;
    private String name;
    private double price;

    public Product() {}

    public Product(final int id, final String name, final double price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
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

}
