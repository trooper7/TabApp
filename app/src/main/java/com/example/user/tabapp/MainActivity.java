package com.example.user.tabapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button okButton, cnlButton;
    EditText adminName, userName, adminPin, userPin;
    TextView adminView, userView;


    public void signupSucceess() {
        // continue to the entrance screen

        Intent intent = new Intent("com.example.user.tabapp.Entrance");
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        okButton = (Button) findViewById(R.id.ok_btn);
        cnlButton = (Button) findViewById(R.id.cancel_btn);
        adminView = (TextView) findViewById(R.id.pin_admin_txt);
        userView = (TextView) findViewById(R.id.pin_user_txt);
        adminName = (EditText) findViewById(R.id.name_txt);
        adminPin = (EditText) findViewById(R.id.pin_txt);
        userName = (EditText) findViewById(R.id.name_txt2);
        userPin = (EditText) findViewById(R.id.pin_txt2);


        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    User initAdmin = new User(adminName.getText().toString(), adminPin.getText().toString(), true);
                    User initUser = new User(userName.getText().toString(), userPin.getText().toString(), false);

                    UserManagement usrMgr = new UserManagement();

                    usrMgr.CreateUsersCSV(getApplicationContext(), "users.csv");
                    usrMgr.WriteUserToFile(getApplicationContext(), "users.csv", initAdmin);
                    usrMgr.WriteUserToFile(getApplicationContext(), "users.csv", initUser);

                    signupSucceess();




                } catch (UserException uex) {

                    Toast.makeText(getApplicationContext(), uex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        cnlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}