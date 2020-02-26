package com.types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


public abstract class Account implements Externalizable {

    protected int id;
    protected double balance;


    public Account() {
        System.out.println("Account.Account()");
        // we can use systrace also
    }

    public Account(final int id, final double balance) {
        System.out.println("Account.Account(parameterized)");
        this.id = id;
        this.balance = balance;

    }

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * @param balance
     *            the balance to set
     */
    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public void deposit(final double amt) {
        if (amt >= 0) {
            this.balance += amt;
        }
    }

    public abstract void withdraw(double amt) throws TransactionException;

    /*
     * public void withdraw(final double amt) { if (this.balance >= amt) {
     * this.balance -= amt; } }
     */

    /*
     * (non-Javadoc)
     *
     * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
     */
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        System.out.println("Account.readExternal()");
        this.id = in.readInt();
        this.balance = in.readDouble();

    }

    /*
     * (non-Javadoc)
     *
     * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
     */
    public void writeExternal(final ObjectOutput out) throws IOException {
        // TODO Auto-generated method stub
        System.out.println("Account.writeExternal()");
        out.writeInt(this.id);
        out.writeDouble(this.balance);

    }

}

