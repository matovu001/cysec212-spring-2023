package com.example.serviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playMusic(View view) {

        Intent playMusicIntent = new Intent(this, MusicPlayerService.class);
        startService(playMusicIntent);
    }

    public void stopMusic(View view) {
        Intent playMusicIntent = new Intent(this, MusicPlayerService.class);
        stopService(playMusicIntent);
    }
}