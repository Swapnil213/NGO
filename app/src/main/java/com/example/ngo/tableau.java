package com.example.ngo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class tableau extends AppCompatActivity {

    private WebView web_View;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableau);

        web_View = findViewById(R.id.web_View);
        web_View.setWebViewClient(new WebViewClient());
        web_View.loadUrl("https://public.tableau.com/views/final_16829347221310/Dashboard1?:language=en-US&publish=yes&:display_count=n&:origin=viz_share_link");

        WebSettings webSettings = web_View.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}