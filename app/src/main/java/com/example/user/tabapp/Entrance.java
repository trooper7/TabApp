package com.example.user.tabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Entrance extends AppCompatActivity {

    ArrayList<User> registeredUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserManagement usrMgr = new UserManagement();
        registeredUsers = usrMgr.GetUsers(getApplicationContext(), "users.csv");

        setContentView(R.layout.activity_entrance);
    }
}
