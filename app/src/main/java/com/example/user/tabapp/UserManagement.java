package com.example.user.tabapp;

import android.content.Context;
import android.provider.MediaStore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by user on 28/11/2016.
 *
 * This is the class that handles user management operations
 *
 */

public class UserManagement {

    /**
     * This method checks if the users.csv file exists
     */
    public boolean UsersFileExist(Context context, String filename) {
        File f = new File(context.getFilesDir(), filename);
        if(f.exists())
            return true;
        else
            return false;
    }

    public ArrayList<User> GetUsers(Context context, String filename) {
        ArrayList<User> results = new ArrayList<User>();

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader ( fileInputStream ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;

            String readString = buffreader.readLine();

            while(readString != null) {
                // 1. Parse CSV line and create a new User Object
                String[] s = readString.split(";");
                if(s.length>0) {
                    User u = new User(s[0], s[1], Boolean.parseBoolean(s[2]));
                    results.add(u);
                }
                readString = buffreader.readLine();
            }

        } catch(Exception e) {
            return null;
        }

        return results;
    }

    public boolean WriteUserToFile(Context context, String filename, User usr){
        // 1. Write the user record to the file and if everything OK, return true
        // 2. If user is a simple non-admin user, also open his sales CSV file
        FileOutputStream fileOutputStream = null;
        try {
            String fileout = usr.getUsername() + ";" + usr.getPin() + ";" + usr.isAdmin() + "\n";
            fileOutputStream = context.openFileOutput(filename, Context.MODE_APPEND);
            fileOutputStream.write(fileout.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean DeleteUserFromFile(User usr) {
        // 1. Read sequentially the whole CSV file

        // 2. Loop through the users and save each user to the file EXCEPT the one that we want to delete

        return false;
    }



}
