package com.example.pc.a23mart;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class SesActivity extends AppCompatActivity implements View.OnClickListener {

    Button kaydet,durdur,cal;
    ImageView record;
    int RecordNumber;

    private static final int REQUEST_AUDIO_PERMISSION_CODE = 200;
//dosya yolu verme -->
    //private final String filepath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC) + "/record.3gp";

//harici-depolama -->
    private final String filepath = Environment.getExternalStorageDirectory().getPath() + "/record"+RecordNumber+".3gp";

//her defasnda farklı isimle kaydetmek istemezsek RecordNumber değerini arttırmamıza gerek yok -->
    //private final String filepath = Environment.getExternalStorageDirectory().getPath() + "/record.3gp";

    private MediaRecorder recorder;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ses);

        record = findViewById(R.id.sesImage);
        kaydet = findViewById(R.id.kaydetBtn);
        durdur = findViewById(R.id.durdurBtn);
        cal = findViewById(R.id.calBtn);

        kaydet.setOnClickListener((View.OnClickListener) this);
        durdur.setOnClickListener((View.OnClickListener) this);
        cal.setOnClickListener((View.OnClickListener) this);
/*      kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPermissions()){
                    startRecording();
                } else {
                    requestPermissions();
                    startRecording();
                }
            }
        });
        durdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRecording();
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPlaying();
            }
        });  */
    }

    @Override
    public void onClick(View view) {
        
        if (view == kaydet) {
            if(checkPermissions()){
                startRecording();
                RecordNumber++;
            } else {
                requestPermissions();
                startRecording();
                RecordNumber++;

            }
        }
        else if (view == durdur) {
            stopRecording();
        }
        else if (view == cal) {
            startPlaying();
        }
    }

    private void startPlaying() {

        player = new MediaPlayer();

        player.setVolume(1.0f, 1.0f);
        try {
            player.setDataSource(filepath);
            player.prepare();
            player.start();
            Toast.makeText(getApplicationContext(),"Kayıt Çalıyor",Toast.LENGTH_LONG).show();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer arg0) {
                    player.stop();
                    player.release();
                    player = null;
                }
            });
        } catch (Exception e) {
        }
    }

    private void stopRecording() {
        if (recorder != null) {
            Toast.makeText(getApplicationContext(),"Kayıt Durduruldu",Toast.LENGTH_LONG).show();
            recorder.stop();
            recorder.reset();
            recorder.release();
            recorder = null;
        }
    }

    private void startRecording() {
        recorder = new MediaRecorder();

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        recorder.setOutputFile(filepath);

        try {
            recorder.prepare();
            recorder.start();
            Toast.makeText(getApplicationContext(),"Kayıt Yapılıyor",Toast.LENGTH_LONG).show();
        }
        catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {

            // yukarda tanımladığımız code değişkenine göre,
            case REQUEST_AUDIO_PERMISSION_CODE:
                if (grantResults.length> 0) {
                    boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean permissionToStore = grantResults[1] ==  PackageManager.PERMISSION_GRANTED;
                    if (permissionToRecord && permissionToStore) {
                        Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(SesActivity.this, new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE},
                REQUEST_AUDIO_PERMISSION_CODE);
    }

    private boolean checkPermissions() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }
}
