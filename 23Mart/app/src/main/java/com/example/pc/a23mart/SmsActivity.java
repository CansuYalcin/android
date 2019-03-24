package com.example.pc.a23mart;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {

    Button gonder;
    EditText mesaj,telNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        gonder = findViewById(R.id.gonder);
        mesaj = findViewById(R.id.mesaj);
        telNo = findViewById(R.id.telNo);

        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String telNoGonderilicek = telNo.getText().toString();
                String gonderilicekMesaj = mesaj.getText().toString();

                Intent mesajGonder = new Intent(Intent.ACTION_SENDTO);
                mesajGonder.setData(Uri.parse("sms:"+ telNoGonderilicek));
                mesajGonder.putExtra("sms_body", gonderilicekMesaj);
                startActivity(mesajGonder);
            }
        });
    }
}
