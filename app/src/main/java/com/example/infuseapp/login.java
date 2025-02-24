package com.example.infuseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView username = (TextView)  findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton)  findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v) {
                                            if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                                                //correct
                                                Toast.makeText(login.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                                            }else
                                                //incorrect
                                                Toast.makeText(login.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                                        }
                                    }
        );
    }
}