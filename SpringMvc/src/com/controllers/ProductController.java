package com.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Product;
import com.repository.ProductRepositoryImpl;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepositoryImpl repository;

    @RequestMapping("/add")
    public String addProducts() {
        System.out.println("ProductController.addProducts()");
        return "addProduct";
    }

    @RequestMapping("/save")
    public ModelAndView saveAccount(@RequestParam("name") final String name, @RequestParam("price") final double price,
        @RequestParam("category") final String category, @RequestParam("units") final int units, final HttpSession session) {

        Product product = new Product(name, price, category, units);

        this.repository.saveProduct(product);

        return new ModelAndView("addProduct");


    }

}
