package com.example.pc.a23mart;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HaritaActivity extends AppCompatActivity {

    Button haritaGit;
    ImageView hariteResim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harita);

        haritaGit = findViewById(R.id.haritayaGit);
        hariteResim = findViewById(R.id.haritaRsm);

        haritaGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri geoLocation = Uri.parse("geo:40.1311,33.0827");

                // veri aktarmalarında kullandığımız intent'te ACTION_VIEW servisiyle
                // bunu imageView'e aktarıyoruz.
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
