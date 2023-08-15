package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.infuseapp.R;

public class TestimonialInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimonial_info);
    }


    public void openTestimonialWebsite(View view) {
        Uri uri = Uri.parse("https://www.ericsson.com/en/careers/student-young-professionals/internships/meet-our-interns");
        startActivity(new Intent(Intent.ACTION_VIEW, uri));

    }
}