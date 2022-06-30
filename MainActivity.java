package com.example.periodtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    //private ActivityMainBinding binding;


    private Button periodToday;
    private Button noPeriodToday;

    //hamburger Menu Variables
    DrawerLayout drawerLayout;
   // Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    periodToday = findViewById(R.id.period_today_button);
    noPeriodToday = findViewById(R.id.no_period_today_button);
    drawerLayout = findViewById(R.id.drawer_layout);
  //  navigationView = findViewById(R.id.nav_view);
      // toolbar = findViewById(R.id.toolbar);
    //    setActionBar(toolbar);





    //buttons to go to another activity
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

    public void ClickMenu (View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo (View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
//should be able to select which one
    public void ClickHome (View view){
        recreate();
    }

    public void ClickSurveyScreen(View view){
        redirectActivity(this,SurveyScreen.class);
    }
    public void ClickCalendar (View view){
        redirectActivity(this,Calendar.class);
    }
    public void ClickFAQ (View view){
        redirectActivity(this,faqMainActivity.class);
    }

    public static void redirectActivity(Activity activity, Class classComingIn) {
    Intent intent = new Intent(activity,classComingIn);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    activity.startActivity(intent);

    }


}