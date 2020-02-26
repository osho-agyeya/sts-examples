package com.model;

public class Account {

    private int id;
    private String name;
    private double amount;

    public Account() {}

    public Account(final int id, final String name, final double amount) {
        super();
        this.id = id;
        this.name = name;
        this.amount = amount;
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


    public double getAmount() {
        return this.amount;
    }


    public void setAmount(final double amount) {
        this.amount = amount;
    }

}

