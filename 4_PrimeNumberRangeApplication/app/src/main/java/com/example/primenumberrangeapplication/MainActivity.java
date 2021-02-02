package com.example.primenumberrangeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText startNum, endNum;
    Button showMe;
    TextView displayMessage;
    int start, end;
    String primeString="\tPrime: ", compositeString="\tComposite:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startNum = (EditText) findViewById(R.id.startNum);
        endNum   = (EditText) findViewById(R.id.endNum);
        showMe = (Button) findViewById(R.id.showMe);
        displayMessage = (TextView) findViewById(R.id.displayMessage);

        showMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start = Integer.parseInt(startNum.getText().toString());
                end = Integer.parseInt(endNum.getText().toString());

                for(int i = start; i<= end; i++){
                    switch(checkPrime(i)){
                        case "Prime":
                            primeString += i +" ";
                            break;
                        case "Composite":
                            compositeString += i+" ";
                            break;
                    }
                }
                displayMessage.setText(primeString+"\n"+compositeString);
                showMe.setEnabled(false);
            }
        });

    }

    protected String checkPrime(int num){
        boolean flag = true;
        for(int i = 2;i<=Math.sqrt(num); i++){
            if(num % i == 0 ){
                flag = false;
            }
        }
        if(flag){
            return "Prime";
        }else{
            return "Composite";
        }
    }
}