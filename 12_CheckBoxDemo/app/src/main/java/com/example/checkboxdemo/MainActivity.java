package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox creditCard;
    TextView displayCC;
    EditText cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creditCard = findViewById(R.id.creditCard);
        displayCC = findViewById(R.id.displayCC);
        cc = findViewById(R.id.cc);

        creditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(creditCard.isChecked()){
                    displayCC.setText(cc.getText());
                }else{
                    displayCC.setText("xxxx-xxxx-xxxx" + cc.getText().toString().substring(14));
                }
            }
        });
    }
}