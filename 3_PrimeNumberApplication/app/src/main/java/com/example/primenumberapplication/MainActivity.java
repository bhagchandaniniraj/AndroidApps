package com.example.primenumberapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {
    EditText num;
    Button checkPrime;
    TextView displayMessage;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.num);
        checkPrime = findViewById(R.id.checkPrime);
        displayMessage = findViewById(R.id.displayMessage);

        checkPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = Integer.parseInt(num.getText().toString());
                displayMessage.setText(validatePrime(number));

            }
        });

    }
    protected String validatePrime(int num){
        boolean flag = true;
        for(int i = 2; i<=sqrt(num); i++){
            if(num % i == 0){
                flag = false;
            }
        }
        if(flag){
            return "It is Prime...";
        }else{
            return "It is not Prime... ";
        }
    }
}