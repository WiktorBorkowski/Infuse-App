package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.infuseapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome, mnews, mprogrammes;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    String api = "c6ab9f0172164417ac9b5c0aaa524e2a";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome = findViewById(R.id.home);
        mnews = findViewById(R.id.news);
        mprogrammes = findViewById(R.id.programmes);
        ViewPager viewPager = findViewById(R.id.frag_container);
        tabLayout = findViewById(R.id.include);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    public void openEricssonWebsite(View view) {
        Uri uri = Uri.parse("https://www.ericsson.com/en");
        startActivity(new Intent(Intent.ACTION_VIEW, uri));

    }

    public void openPrimary(View view){
        Intent intent = new Intent(this, PrimaryInternshipInfo.class);
        startActivity(intent);
    }

    public void openSecond(View view){
        Intent intent = new Intent(this, SecondaryIntershipInfo.class);
        startActivity(intent);
    }

    public void openThird(View view){
        Intent intent = new Intent(this, TertiaryInternshipInfo.class);
        startActivity(intent);
    }

    public void openBursary(View view){
        Intent intent = new Intent(this, BursaryInfo.class);
        startActivity(intent);
    }
}