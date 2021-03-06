package com.boot.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {

    private int id;
    private String name;
    private double balance;

    public Account() {}


    public Account(final int id, final String name, final double balance) {
        super();
        this.id = id;
        this.name = name;
        this.balance = balance;
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

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }


}
