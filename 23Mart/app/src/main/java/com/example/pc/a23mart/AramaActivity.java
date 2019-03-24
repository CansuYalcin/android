package com.example.pc.a23mart;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AramaActivity extends AppCompatActivity {

    Button aramaBtn;
    EditText telNoAramaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arama);

        aramaBtn = findViewById(R.id.arama);
        telNoAramaText = findViewById(R.id.telNoArama);

        aramaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent aramaIntent = new Intent(Intent.ACTION_DIAL);
                aramaIntent.setData(Uri.parse("tel:" + telNoAramaText.getText().toString()));

                if (aramaIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(aramaIntent);
                }
            }
        });
    }
}
