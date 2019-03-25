package com.example.pc.a23mart;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        web = findViewById(R.id.internet);

        String url = "https://gelecegiyazanlar.turkcell.com.tr";

        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(url);

        final ProgressDialog progressDialog = ProgressDialog.show(WebActivity.this,"Geleceği Yazanlar",
                "Yükleniyor...",true);
        progressDialog.show();

        web.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                Log.i("Sayfa yüklendi mi?","kod bloğu içine girdi...");
                super.onPageFinished(view, url);
                Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
