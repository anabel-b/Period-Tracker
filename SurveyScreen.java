package com.example.periodtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;

public class SurveyScreen extends AppCompatActivity {
    //adding stuff to the survey screen DO NOT REMOVE- Anabel
    DrawerLayout drawerLayout;

    public static final String TAG ="Survey";
    CheckBox fatigue,nausea,flow,headache,cramping;
    Button surveyHome, surveyDone;
    Switch birthControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "inside onCreate method");
        //DO NOT REMOVE- Anabel
        drawerLayout = findViewById(R.id.drawer_layout);

        //change the layout
        setContentView(R.layout.activity_survey_screen);
        fatigue = findViewById(R.id.FatigueCheck);
        nausea = findViewById(R.id.NauseaCheck);
        flow = findViewById(R.id.FlowCheck);
        headache = findViewById(R.id.HeadacheCheck);
        cramping = findViewById((R.id.IntenseCrampCheck));
        surveyDone = findViewById(R.id.survey_done_button);
        surveyHome = findViewById(R.id.survey_home_button);
        birthControl = findViewById(R.id.BirthControl);

        Log.d(TAG, "End of onCreate method");
        surveyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

    }
// DO NOT REMOVE
    public void ClickMenu (View view){
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo (View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome (View view){
        MainActivity.redirectActivity(this,MainActivity.class
        );
    }
    public void ClickSurveyScreen (View view){
        recreate();
    }
    public void ClickCalendar (View view){
        MainActivity.redirectActivity(this,Calendar.class);
    }

    public void ClickFAQ (View view){
        MainActivity.redirectActivity(this,faqMainActivity.class);
    }

}