package com.types;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class AccountManager {

    /**
     * <p>
     * <b> TODO : Insert description of the method's responsibility/role. </b>
     * </p>
     *
     * @param args
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub

        /*
         * Account acc = new Account(1, 50000); // cannot create objects of //
         * abstract class acc.deposit(10000); acc.withdraw(5000);
         * System.out.println("account balance=" + acc.getBalance());
         */

        try {
            SavingsAccount savingsAccount = new SavingsAccount(2, 40000, 1000);
            savingsAccount.deposit(1000);
            savingsAccount.withdraw(200);
            System.out.println("savings balance=" + savingsAccount.getBalance());

            // acc = new SavingsAccount(3, 3000, 1000);
            Account acc = new SavingsAccount(3, 3000, 1000);// we can still
                                                            // create
                                                            // object of
                                                            // derived
                                                            // and reference of
                                                            // base asbtract
                                                            // class

            // reference type is account and obj is SavingsAccount
            acc.withdraw(2500);
        } catch (TransactionException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

}
