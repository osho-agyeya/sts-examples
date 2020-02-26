package com.types;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class SavingsAccount extends Account {

    private double minimumBalance;

    /**
     * <p>
     * <b> TODO : Insert description of the method's responsibility/role. </b>
     * </p>
     *
     * @param minimumBalance
     */

    public SavingsAccount() {
        super();
        System.out.println("SavingsAccount.SavingsAccount()");
    }

    public SavingsAccount(final int id, final double balance, final double minimumBalance) {
        super(id, balance);
        System.out.println("SavingsAccount.SavingsAccount(parameterized)");
        /*
         * this.id = id; this.balance = balance;
         */
        this.minimumBalance = minimumBalance;
    }

    /**
     * @return the minimumBalance
     */
    public double getMinimumBalance() {
        return this.minimumBalance;
    }

    /**
     * @param minimumBalance
     *            the minimumBalance to set
     */
    public void setMinimumBalance(final double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.types.Account#withdraw(double)
     */
    public void withdraw(final double amt) throws TransactionException {
        // TODO Auto-generated method stub
        // super.withdraw(amt);
        if (this.balance - amt > this.minimumBalance) {
            this.balance -= amt;
        } else {
            throw new TransactionException("Withdraw failed:Insufficient funds");
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.types.Account#readExternal(java.io.ObjectInput)
     */
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        System.out.println("SavingsAccount.readExternal()");
        super.readExternal(in);
        this.minimumBalance = in.readDouble();

    }

    /*
     * (non-Javadoc)
     *
     * @see com.types.Account#writeExternal(java.io.ObjectOutput)
     */
    public void writeExternal(final ObjectOutput out) throws IOException {
        // TODO Auto-generated method stub
        System.out.println("SavingsAccount.writeExternal()");
        super.writeExternal(out);
        out.writeDouble(this.minimumBalance);
    }


}
