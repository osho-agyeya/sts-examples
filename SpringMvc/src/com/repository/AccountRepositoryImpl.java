package com.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.model.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> fetchAll() {

        String sql = "select * from accounts";

        /*
         * return jdbcTemplate.query("select * from accounts", new
         * RowMapper<Account>(){ public Account mapRow(ResultSet rs, int index)
         * throws java.sql.Exception{ return new Account(rs.getInt("id"),
         * rs.getString("name"), rs.getDouble("balance")); }; });
         *
         * this is using anonymous class
         */
        List<Account> accounts = this.jdbcTemplate.query(sql, (rs, rowNo) -> {
            return new Account(rs.getInt("id"), rs.getString("name"), rs.getDouble("balance"));
        });
        for (Account account : accounts) {
            System.out.println(account.getId());
            System.out.println(account.getName());
            System.out.println(account.getBalance());

        }
        System.out.println("******************");
        return accounts;

    }

    public void updateAccount(final Account account) {
        String updateSQL = "update accounts set name = ? and balance=? where id = ?";
        int rowsAffected = this.jdbcTemplate.update(updateSQL, account.getName(), account.getBalance(), account.getId());
        if (rowsAffected == 1) {
            System.out.println("Updated account..");
        } else {
            System.out.println("Not updated the account..");
        }

    }


}
