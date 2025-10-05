package com.example.mustinfohub;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); // Keeps navigation inside the app
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript

        // The URL from your request
        webView.loadUrl("https://www.must.ac.ug/");
        //webView.loadUrl("https://softpower.ug/");
    }
}