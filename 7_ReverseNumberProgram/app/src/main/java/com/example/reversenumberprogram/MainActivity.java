package com.example.reversenumberprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText reverseNumber;
    Button calculateMe;
    TextView message;
    int n, remainder;
    Integer rev=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reverseNumber = findViewById(R.id.reverseNumber);
        calculateMe = findViewById(R.id.calculateMe);
        message = findViewById(R.id.message);

        calculateMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.parseInt(reverseNumber.getText().toString());
                while(n != 0){
                    remainder = n%10;
                    rev = rev*10 + remainder;
                    n /=10;
                }
                toastMe(reverseNumber.getText().toString(), rev);
                message.setText("The reverse number for "+ reverseNumber.getText().toString() + " is "+ rev);
                reverseNumber.setText("");
            }
        });

    }
    protected void toastMe(String originalNumber, Integer num){
        String msg = "The reverse number for "+ originalNumber + " is "+ num;
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}