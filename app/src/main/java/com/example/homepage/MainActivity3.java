package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.infuseapp.R;

public class MainActivity3 extends AppCompatActivity {
    private CheckBox checkbox1, checkbox2, checkbox3;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView);
        String video = "<<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/TkoJPVQGHCw\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        webView.loadData(video, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        Button switchButton2 = findViewById(R.id.apply);
        switchButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to switch to ApplyActivity
                Intent intent = new Intent(MainActivity3.this, applyActivity.class);
                startActivity(intent);
            }
        });

        Button switchButton = findViewById(R.id.loginbtn);
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to switch to LoginActivity
                Intent intent = new Intent(MainActivity3.this, login.class);
                startActivity(intent);
            }
        });

        checkbox1 = findViewById(R.id.checkbox1);
        checkbox2 = findViewById(R.id.checkbox2);
        checkbox3 = findViewById(R.id.checkbox3);
        submitButton = findViewById(R.id.apply);

        // Set listeners for checkboxes
        checkbox1.setOnCheckedChangeListener(checkBoxListener);
        checkbox2.setOnCheckedChangeListener(checkBoxListener);
        checkbox3.setOnCheckedChangeListener(checkBoxListener);
    }

    private final CompoundButton.OnCheckedChangeListener checkBoxListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int numChecked = 0;

            if (checkbox1.isChecked()) numChecked++;
            if (checkbox2.isChecked()) numChecked++;
            if (checkbox3.isChecked()) numChecked++;

            submitButton.setEnabled(numChecked == 3);
        }
    };
}
