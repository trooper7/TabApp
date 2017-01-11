package com.example.user.tabapp;

/**
 * Created by user on 4/12/2016.
 */

public class ProductException extends Exception {
    public  ProductException(){
        //default constructor
    }

    public ProductException(String msg) {
        super(msg);
    }
}
