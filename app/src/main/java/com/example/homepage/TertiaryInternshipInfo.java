package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.infuseapp.R;

public class TertiaryInternshipInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_info);
    }


    public void openTest(View view){
        Intent intent = new Intent(this, TestimonialInfo.class);
        startActivity(intent);
    }

    public void openApplication(View view){
        Intent intent = new Intent(this, ApplicationPage.class);
        startActivity(intent);
    }
}