package com.example.malefemalecounterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button maleCounter, femaleCounter;
    TextView displayMessage;
    String male="Male: ",female="Female: ", msg;
    int maleCount=0, femaleCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button maleCounter = findViewById(R.id.maleCounter);
        Button femaleCounter = findViewById(R.id.femaleCounter);
        final TextView displayMessage = findViewById(R.id.messageDisplay);

        maleCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maleCount++;
                msg = "\t"+ male + maleCount + "\n\t" + female + femaleCount;
                displayMessage.setText(msg);
                displayToast(msg);
            }
        });

        femaleCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                femaleCount++;
                msg = "\t"+ male + maleCount + "\n\t" + female + femaleCount;
                displayMessage.setText(msg);
                displayToast(msg);
            }
        });
    }
    protected void displayToast(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }
}