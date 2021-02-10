package com.example.togglebuttonapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb;
    TextView displayMessage;
    MediaPlayer voiceOn, voiceOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = findViewById(R.id.onOffButton);
        displayMessage = findViewById(R.id.displayMessage);

        //In Ubuntu or Linux

        AudioManager audioManager = (AudioManager) getSystemService(MainActivity.this.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);

        voiceOn = MediaPlayer.create(MainActivity.this, R.raw.on);
        voiceOff = MediaPlayer.create(MainActivity.this, R.raw.off);

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = tb.getText().toString();
                if(status.equals("OFF")){
                    displayMessage.setText("The Switch is " + status);
                    voiceOff.setVolume(100,100);
                    voiceOff.start();
                }else{
                    displayMessage.setText("The Switch is " + status);
                    voiceOn.setVolume(100,100);
                    voiceOn.start();
                }
            }
        });
    }
}