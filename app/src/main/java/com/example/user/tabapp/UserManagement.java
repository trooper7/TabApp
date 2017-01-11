package com.example.user.tabapp;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by user on 28/11/2016.
 *
 * This is the class that handles user management operations
 *
 */

public class UserManagement {


    /**
     * This method creates the user CSV file into the specified path
     * @param context
     * @return
     */
    public boolean CreateUsersCSV(Context context, String path) {
        // 1. Create file
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(path, Context.MODE_PRIVATE);

            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. If file successfully created, return true, else return false

        return context.getFileStreamPath(path).exists();
    }


    public boolean WriteUserToFile(Context context, String path, User usr){
        // 1. Check if Users file exists IF YES open for append, IF NO call CreateUsersCSV

        // 2. Write the user record to the file and if everything OK, return true

        // 3. If user is a simple non-admin user, also open his sales CSV file
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(path, Context.MODE_APPEND);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            fileOutputStream.write(usr.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean DeleteUserFromFile(User usr) {
        // 1. Read sequentially the whole CSV file

        // 2. Loop through the users and save each user to the file EXCEPT the one that we want to delete

        return false;
    }

}
