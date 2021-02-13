package com.example.likedislikeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView likeInc, likeDec, dislikeInc, dislikeDec;
    int likeCount=0,dislikeCount=0;
    TextView displayMessage;
    String msg="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeInc = findViewById(R.id.likeInc);
        likeDec = findViewById(R.id.likeDec);
        dislikeInc = findViewById(R.id.dislikeInc);
        dislikeDec = findViewById(R.id.dislikeDec);
        displayMessage = findViewById(R.id.displayMessage);

        likeInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(++likeCount,dislikeCount);
            }
        });
        dislikeInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(likeCount,++dislikeCount);
            }
        });

        likeDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeCount >0 )
                    display(--likeCount,dislikeCount);
            }
        });
        dislikeDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dislikeCount > 0)
                    display(likeCount,--dislikeCount);
            }
        });

    }
    protected void display(int like, int dislike){
        msg = "Like Counter :" + like;
        msg+="\nDislike Counter: " + dislike;
        displayMessage.setText(msg);
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}