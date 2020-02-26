package com.boot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.boot.model.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /* (non-Javadoc)
     * @see com.boot.repository.AccountRepository#fetchAll()
     */
    @Override
    public List<Account> fetchAll() {

        return this.jdbcTemplate.query("select * from accounts",
            (rs, rowNo) -> new Account(rs.getInt("id"), rs.getString("name"), rs.getDouble("balance")));

    }

}
