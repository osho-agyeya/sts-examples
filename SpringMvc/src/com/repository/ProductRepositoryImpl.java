package com.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveProduct(final Product product) {

        String insertSQL = "insert into products(name, price, category, units) values(?, ?, ?, ?)";
        int rowsAffected =
            this.jdbcTemplate.update(insertSQL, product.getName(), product.getPrice(), product.getCategory(), product.getUnits());
        if (rowsAffected == 1) {
            System.out.println("Inserted..");
        } else {
            System.out.println("Not inserted..");
        }

    }


}
