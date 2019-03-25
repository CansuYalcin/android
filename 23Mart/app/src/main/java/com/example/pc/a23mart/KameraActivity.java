package com.example.pc.a23mart;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class KameraActivity extends AppCompatActivity {

    private static final int VIDEO_ACTION_CODE = 101;
    private static final int IMAGE_ACTION_CODE = 102;

    Button fotoCek,videoCek;
    ImageView foto;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);

        fotoCek = findViewById(R.id.fotoCek);
        videoCek = findViewById(R.id.videoCek);
        foto = findViewById(R.id.foto);
        video = findViewById(R.id.video);

        fotoCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(fotoIntent, IMAGE_ACTION_CODE);
            }
        });

        videoCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(takePictureIntent, VIDEO_ACTION_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != RESULT_OK) return;

        switch (requestCode) {
            case VIDEO_ACTION_CODE :
                //VideoView videoView = (VideoView) findViewById(R.id.video);
                video.setVideoURI(data.getData());
                video.setMediaController(new MediaController(KameraActivity.this));
                video.requestFocus();
                video.start();
                break;

            case IMAGE_ACTION_CODE :
                Log.i("kklklkl","mdlkflksdjşfjşflkşflkfş");
                Bundle extras = data.getExtras();
                ((ImageView) findViewById(R.id.foto)).setImageBitmap((Bitmap) extras.get("data"));
                //foto.setImageBitmap((Bitmap) extras.get("data"));
                break;
            default:
                break;
        }

    }
}

