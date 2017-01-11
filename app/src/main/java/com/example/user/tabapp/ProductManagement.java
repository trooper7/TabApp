package com.example.user.tabapp;

/**
 * Created by user on 7/12/2016.
 */

public class ProductManagement {

    public boolean CreateProductsCSV (String path) {
        // Create CSV File

        // If file successfully created, return true, else return false

        return false;
    }

    public boolean WriteProductToFile (String path, Product product){
        // If file exists open for append, if not, call CreateProductsCSV

        // Write the product record to the file and if everything OK, return true

        return false;
    }

    public boolean DeleteProductFromFile (Product product){
        // Read sequentially the whole CSV File

        // Loop through the users and save each user to the file EXCEPT the one that we want to delete

        return false;
    }
}
