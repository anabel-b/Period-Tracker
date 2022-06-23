package com.example.periodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button periodToday;
    private Button noPeriodToday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    periodToday = findViewById(R.id.period_today_button);
    noPeriodToday = findViewById(R.id.no_period_today_button);

    periodToday.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //@haylin change this so that it goes together with what you have!
            startActivity(new Intent(MainActivity.this,PeriodBleeding.class));
        }
    });

    noPeriodToday.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //@haylin change this so that it goes together with what you have!
            startActivity(new Intent(MainActivity.this,SurveyScreen.class));
        }
    });

    }




}