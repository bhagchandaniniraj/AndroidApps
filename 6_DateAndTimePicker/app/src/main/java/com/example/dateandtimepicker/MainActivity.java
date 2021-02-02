package com.example.dateandtimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dateText, timeText;
    Button showMe;
    TextView displayMessage;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateText = findViewById(R.id.dateText);
        timeText = findViewById(R.id.timeText);

        showMe = findViewById(R.id.showMe);
        displayMessage = findViewById(R.id.displayMessage);

        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(MainActivity.this,
                                                            new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateText.setText(dayOfMonth + " - " + month +" - "+ year);
                    }
                }, 2021,2,2);
                dp.show();
            }
        });
        timeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tp = new TimePickerDialog(MainActivity.this,
                                                            new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeText.setText("Hour: " + hourOfDay + " : " + "Minutes: " + minute );
                    }
                },12,00,true);
                tp.show();
            }
        });
        showMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = "\t Date: " +dateText.getText().toString() +
                        "\n\t Time: " + timeText.getText().toString();
                displayMessage.setText(msg);
                showToast(msg);
            }
        });
    }
    protected void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}