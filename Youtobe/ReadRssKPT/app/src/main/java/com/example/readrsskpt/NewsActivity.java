package com.example.readrsskpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        WebView webview = (WebView) findViewById(R.id.webviewTinTuc);
        Intent intent = getIntent();
        String link = intent.getStringExtra("linkTinTuc");
       //Toast.makeText(this, link, Toast.LENGTH_SHORT).show();
        webview.loadUrl(link);
        webview.setWebViewClient(new WebViewClient());
    }
}