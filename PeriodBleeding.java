package com.example.periodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Objects;

public class PeriodBleeding extends AppCompatActivity {
    private ImageButton spottingImage;
    private ImageButton lightPeriodImage;
    private ImageButton regularPeriodImage;
    private ImageButton heavyPeriodImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period_bleeding);
        spottingImage = (ImageButton) findViewById(R.id.spotting_button);
        lightPeriodImage = (ImageButton) findViewById(R.id.Light_Period);
        regularPeriodImage = (ImageButton) findViewById(R.id.Regular_Period);
        heavyPeriodImage = (ImageButton) findViewById(R.id.Heavy_Period);

        spottingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData("Spotting");
                startActivity(new Intent(PeriodBleeding.this,SurveyScreen.class));
            }
        });
        lightPeriodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData("Light Period");
                startActivity(new Intent(PeriodBleeding.this,SurveyScreen.class));
            }
        });
        regularPeriodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData("Regular Period");
                startActivity(new Intent(PeriodBleeding.this,SurveyScreen.class));
            }
        });
        heavyPeriodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData("Heavy Period");
                startActivity(new Intent(PeriodBleeding.this,SurveyScreen.class));
            }
        });
    }

    private void setData(String string) {
        if(string.equals("Spotting")){
        //here is where we store data
        }
        if(string.equals("Light Period")){

        }
        if(string.equals("Regular Period")){

        }
        if(string.equals("Heavy Period")){

        }
    }


}