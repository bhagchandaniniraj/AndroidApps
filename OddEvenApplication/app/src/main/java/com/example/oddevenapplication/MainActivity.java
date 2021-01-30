package com.example.oddevenapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText startNum,endNum;
    TextView displayMe;
    Button showMe;
    int start,end;
    String oddMsg="Odd: ", evenMsg="Even: ";
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startNum = (EditText) findViewById(R.id.startNum);
        endNum = (EditText) findViewById(R.id.endNum);
        showMe = (Button) findViewById(R.id.showMe);
        displayMe = (TextView) findViewById(R.id.displayMe);

        showMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start = Integer.parseInt(startNum.getText().toString());
                end = Integer.parseInt(endNum.getText().toString());
                for(i = start; i<end;i++){
                    switch (checkOddEven(i)){
                        case "Odd":
                            oddMsg += i +" ";
                            break;
                        case "Even":
                            evenMsg += i + " ";
                    }
                }
                displayMe.setText("\t"+oddMsg+"\n\t"+evenMsg);
                showMe.setEnabled(false);
            }
        });
    }
    protected String checkOddEven(int num){
        if(num %2 == 0 ){
            return "Even";
        }else{
            return "Odd";
        }
    }
}