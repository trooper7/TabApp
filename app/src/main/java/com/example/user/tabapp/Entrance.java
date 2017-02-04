package com.example.user.tabapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Entrance extends AppCompatActivity {

    ArrayList<User> registeredUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
        View linearLayout =  findViewById(R.id.activity_entrance);

        UserManagement usrMgr = new UserManagement();
        registeredUsers = usrMgr.GetUsers(getApplicationContext(), "users.csv");

        for(User registeredUser: registeredUsers){
            TextView textView = new TextView(this);
            textView.setText(registeredUser.toString());
            textView.setBackgroundResource(R.drawable.common_google_signin_btn_text_light_pressed);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                }
            });

            ((LinearLayout)linearLayout).addView(textView);
        }
    }
}
