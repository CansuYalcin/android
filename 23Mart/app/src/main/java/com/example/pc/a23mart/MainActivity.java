package com.example.pc.a23mart;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button kamera, ses,harita,web,sms,arama;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kamera = findViewById(R.id.kamera);
        ses = findViewById(R.id.ses);
        harita = findViewById(R.id.harita);
        web = findViewById(R.id.web);
        sms = findViewById(R.id.sms);
        arama = findViewById(R.id.arama);

        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kameraYonlendirme = new Intent(MainActivity.this,KameraActivity.class);
                startActivity(kameraYonlendirme);
            }
        });

        ses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kameraYonlendirme = new Intent(MainActivity.this,SesActivity.class);
                startActivity(kameraYonlendirme);
            }
        });

        harita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kameraYonlendirme = new Intent(MainActivity.this,HaritaActivity.class);
                startActivity(kameraYonlendirme);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kameraYonlendirme = new Intent(MainActivity.this,WebActivity.class);
                startActivity(kameraYonlendirme);
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kameraYonlendirme = new Intent(MainActivity.this,SmsActivity.class);
                startActivity(kameraYonlendirme);
            }
        });

        arama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kameraYonlendirme = new Intent(MainActivity.this,AramaActivity.class);
                startActivity(kameraYonlendirme);
            }
        });


    }
}
