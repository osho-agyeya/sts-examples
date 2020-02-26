
package com.org;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AccountTest {

    @Test
    public void testWithdrawAmount() {
        Account account = new Account("A1", 100, new Address("India", "UP", "Lucknow", "Mahanagar"), new Owner("Osho", "Agyeya"));
        try {
            account.withdraw(-200);
        } catch (Exception e) {
            assertTrue(e != null);
            System.out.println(e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositAmount() {
        Account account = new Account("A1", 100, new Address("India", "UP", "Lucknow", "Mahanagar"), new Owner("Osho", "Agyeya"));
        account.deposit(-200);

    }

    @Test
    public void testWithdrawValid() {
        Account account = new Account("A1", 100, new Address("India", "UP", "Lucknow", "Mahanagar"), new Owner("Osho", "Agyeya"));
        try {
            account.withdraw(200);
        } catch (Exception e) {
            assertTrue(e != null);
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testWithdraw() {
        Account account = new Account("A1", 100, new Address("India", "UP", "Lucknow", "Mahanagar"), new Owner("Osho", "Agyeya"));
        account.withdraw(40);
        assertEquals(60, account.getBalance(), 0.001);
    }

    @Test
    public void testDeposit() {
        Account account = new Account("A1", 100, new Address("India", "UP", "Lucknow", "Mahanagar"), new Owner("Osho", "Agyeya"));
        account.deposit(40);
        assertEquals(140, account.getBalance(), 0.001);
    }

    @Test
    public void testSetBalanceNegative() {
        Account account = new Account("A1", 100, new Address("India", "UP", "Lucknow", "Mahanagar"), new Owner("Osho", "Agyeya"));
        try {
            account.setBalance(-40);
        } catch (Exception e) {
            assertTrue(e != null);
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSetBalance() {
        Account account = new Account("A1", 100, new Address("India", "UP", "Lucknow", "Mahanagar"), new Owner("Osho", "Agyeya"));
        assertEquals(account.getBalance(), 100, 0.001);


    }


}
