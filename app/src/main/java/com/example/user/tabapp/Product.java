package com.example.user.tabapp;

/**
 * Created by user on 4/12/2016.
 * This is the DTO for the Product entity
 */

public class Product {
    private String productname;
    private double price;

    public Product() {
        //default constructor
    }

    public Product(String productname, double price) throws ProductException {
        this.setProductname(productname);
        this.setPrice(price);
    }


    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) throws ProductException {
        if(productname.isEmpty())
            throw new ProductException("Add a product");

        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws ProductException {
        if(price!=(double)Math.round(price * 100)/100)
            throw new ProductException("Invalid price entered");

        this.price = price;
    }
}



