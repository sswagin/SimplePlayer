package com.example.smaug.simpleplayer;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.smaug.simpleplayer.services.PlayBackService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent playBackIntent = PlayBackService.newInstance(this);
        startService(playBackIntent);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stopService(PlayBackService.newInstance(MainActivity.this))   ;
            }
        }, 5000);
      //  bindService(playBackIntent);

    }
}
