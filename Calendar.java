package com.example.periodtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Calendar extends AppCompatActivity {
    //DO NOT REMOVE - Anabel
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
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
        MainActivity.redirectActivity(this,SurveyScreen.class);
    }
    public void ClickCalendar (View view){
        recreate();
    }
    public void ClickFAQ (View view){
        MainActivity.redirectActivity(this,faqMainActivity.class);
    }




}