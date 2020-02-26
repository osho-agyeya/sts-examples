
package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Account;
import com.repository.exceptions.AccountRepositoryException;

public class AccountRepositoryImp implements AccountRepository {

    private static final String DB_URL = "jdbc:derby://localhost:1527/TrainingDB";

    public List<Account> fetchAllAccounts() throws AccountRepositoryException {
        try {
            // load the derby driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(AccountRepositoryImp.DB_URL)) {
            String query = "select * from accounts";
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query);
            Account account = null;
            List<Account> allAccounts = new ArrayList<>();
            while (resultSet.next()) { // resultSet is a live Object
                account = new Account(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("balance"));
                allAccounts.add(account);
            }
            return allAccounts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Account fetchAccountById(final int id) throws AccountRepositoryException {
        // TODO Auto-generated method stub
        try (Connection conn = DriverManager.getConnection(AccountRepositoryImp.DB_URL)) {
            String query = "select * from accounts where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Account account = null;
            while (resultSet.next()) { // resultSet is a live Object
                account = new Account(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("balance"));
            }
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveAccount(final Account newAccount) throws AccountRepositoryException {
        // TODO Auto-generated method stub
        try {
            // load the derby driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(AccountRepositoryImp.DB_URL)) {
            String insertSQL = "insert into accounts (name, balance) values(?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
            // we can use preparedStatement when we want to take input from the
            // user and use it in a query
            String fullName = newAccount.getName();
            double balance = newAccount.getAmount();
            preparedStatement.setString(1, fullName);
            preparedStatement.setDouble(2, balance); // this 1 ,2 is for ?,?
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Inserted successfully");
            } else {
                System.out.println("Failed to insert");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount() throws AccountRepositoryException {
        // TODO Auto-generated method stub

    }

    public void removeAccount(final int id) throws AccountRepositoryException {
        // TODO Auto-generated method stub
        try {
            // load the derby driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(AccountRepositoryImp.DB_URL)) {
            String removeSQL = "delete from accounts where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(removeSQL);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("Deleted successfully");
            } else {
                System.out.println("Failed to delete");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
