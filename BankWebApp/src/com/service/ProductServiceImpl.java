package com.service;

import com.model.Product;

public class ProductServiceImpl implements ProductService {

    private static int count;

    @Override
    public Product seachProduct(final String name) {
        return new Product(++ProductServiceImpl.count, name, ProductServiceImpl.count * 1000);
    }

}
