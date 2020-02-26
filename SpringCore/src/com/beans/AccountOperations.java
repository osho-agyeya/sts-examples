package com.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.model.Account;

@Component
public class AccountOperations {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createAccount(final String name, final double balance) {
        String insertsql = "insert into accounts (name,balance) values (?,?)";
        int rowsAffected = this.jdbcTemplate.update(insertsql, name, balance);
        if (rowsAffected == 1) {
            System.out.println("Inserted..");
        } else {
            System.out.println("Not inserted..");
        }

    }

    public void fetchAccounts() {
        String sql = "select * from accounts";
        List<Account> accounts = this.jdbcTemplate.query(sql, (rs, rowNo) -> {
            return new Account(rs.getInt("id"), rs.getString("name"), rs.getDouble("balance"));
        });
        for (Account account : accounts) {
            System.out.println(account.getId());
            System.out.println(account.getName());
            System.out.println(account.getBalance());
        }
    }

}
