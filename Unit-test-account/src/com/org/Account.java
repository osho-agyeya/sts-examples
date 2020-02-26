
package com.org;

// Account class to maintain bank account details
public class Account {


    private String accountID;
    private double balance;
    private Address address;
    private Owner owner;

    /**
     * Constructor
     */
    public Account(final String accountID, final double balance, final Address address, final Owner owner) {
        this.accountID = accountID;
        setBalance(balance);
        this.address = address;
        this.owner = owner;

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
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative,balance=" + balance);
        }
        this.balance = balance;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * @return the accountID
     */
    public String getAccountID() {
        return this.accountID;
    }

    /**
     * @return the owner
     */
    public Owner getOwner() {
        return this.owner;
    }


    /**
     * withdraw the money
     */
    public void withdraw(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount should not be negative. amount=" + amount);
        }
        if (this.balance - amount < 0) {
            throw new IllegalArgumentException("cannot withdraw money more than balance. balance=" + this.balance);
        }
        this.balance -= amount;
        System.out.println("Balance after withdrawal is " + this.balance);
    }

    /**
     * deposit the money
     */
    public void deposit(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount should not be negative. amount=" + amount);
        }
        this.balance += amount;
        System.out.println("Balance after deposit is " + this.balance);

    }

    /*
     * public static void main(final String[] args) { final ArrayList<Integer>
     * arr = new ArrayList<>(); arr.add(12); }
     */

}
