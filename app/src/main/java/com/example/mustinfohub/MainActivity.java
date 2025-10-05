package com.example.mustinfohub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnViewWebsite = findViewById(R.id.btnViewWebsite);
        Button btnFetchNews = findViewById(R.id.btnFetchNews);

        btnViewWebsite.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            startActivity(intent);
        });

        btnFetchNews.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NewsActivity.class);
            startActivity(intent);
        });

        // Button for Jsoup/Web Scraping example
        //Button btnFetchSoftPowerNews = findViewById(R.id.btnFetchSoftPowerNews);
        //btnFetchSoftPowerNews.setOnClickListener(v -> {
            // This Intent starts the SoftPowerNewsActivity
          //  Intent intent = new Intent(MainActivity.this, mustNewsActivity.class);
            //startActivity(intent);
        //});

        Button btnFetchMustNews = findViewById(R.id.btnFetchMUSTNews);
        btnFetchMustNews.setText("Fetch MUST News (Web Scraping)");

        btnFetchMustNews.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MustNewsActivity.class);
            startActivity(intent);
        });
    }
}