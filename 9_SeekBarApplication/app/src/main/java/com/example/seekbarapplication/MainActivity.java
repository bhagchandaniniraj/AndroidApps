package com.example.seekbarapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView displayMessage;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        displayMessage = findViewById(R.id.displayMessage);
        iv = findViewById(R.id.images);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    displayMessage.setText("Seek Value " + progress);
                    if(progress >10 && progress < 25){
                        iv.setImageResource(R.raw.boy1);
                    }
                    if(progress >25 && progress < 50){
                        iv.setImageResource(R.raw.boy2);
                    }
                    if(progress >50 && progress < 75){
                        iv.setImageResource(R.raw.woman1);
                    }
                    if(progress >75 && progress < 100){
                        iv.setImageResource(R.raw.woman3);
                    }
                    if(progress < 10){
                        iv.setImageResource(android.R.color.transparent);
                    }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}