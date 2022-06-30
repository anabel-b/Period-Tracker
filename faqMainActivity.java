package com.example.periodtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class faqMainActivity extends AppCompatActivity {

    //We will need a recyclerView, arrayList for questions(& answers?), questionsAdapter, column counts

    private static final String TAG = "FAQActivity";

    private RecyclerView recyclerView;
    private ArrayList<Questions> questionsArrayList;
    private FAQsAdapter faqsAdapter;

    private EditText searchEditText;
    private Button searchButton;

    //notifications
    private Button notifyButton;

    private  int gridColumnCount; //use column # in integers.xml

    //Will be used for sending notification
    private NotificationManager notificationManager;
    private PendingIntent pendingNotificationIntent;

    //notifications
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private static final String PRIMARY_CHANNEL_NAME = "my primary notification channel";
    private static final int IMPORTANCE_LEVEL = NotificationManager.IMPORTANCE_DEFAULT;
    private static final int NOTIFICATION_ID_0 = 0; //to update notification



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //notifications
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notifyButton = findViewById(R.id.notify_button);

        searchEditText = findViewById(R.id.search_edit_txt);
        searchButton = findViewById(R.id.search_button);



        gridColumnCount = getResources().getInteger(R.integer.grid_column_count); //gets column count as int from integer resource file

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount)); //uses the value from the integers.xml file

        questionsArrayList = new ArrayList<>();
        faqsAdapter = new FAQsAdapter(this, questionsArrayList);
        recyclerView.setAdapter(faqsAdapter); //adapter connects data with the view

        loadQuestions();

    }

    private void loadQuestions() {
        questionsArrayList.clear();

        String [] questionTitles = getResources().getStringArray(R.array.questions_titles);
        String [] answersToQuestions = getResources().getStringArray(R.array.answers);

        for(int i =0; i<questionTitles.length; i++){
            questionsArrayList.add(new Questions(questionTitles[i], answersToQuestions[i]));
        }

        faqsAdapter.notifyDataSetChanged();

    }

    public void searchLocation(View view) {
        String location = searchEditText.getText().toString();

        Uri geoLoc = Uri.parse("geo: 0, 0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, geoLoc);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(this, "Click \"Notify me\" Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.preferences:
                Toast.makeText(this, "This is Preferences", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //notifications
    protected void sendNotification() {
        Log.d(TAG, "inside sendNotification method");

        NotificationCompat.Builder notificationBuilder;
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID_0, intent, PendingIntent.FLAG_MUTABLE);

        if(Build.VERSION.SDK_INT >= 26){//API 26 or greater needs channel
            Log.d(TAG, "inside >= 26 block of code");
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID, PRIMARY_CHANNEL_NAME, IMPORTANCE_LEVEL);
            notificationChannel.setDescription("Reminders");

            notificationManager.createNotificationChannel(notificationChannel);

            notificationBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                    .setContentTitle("Upcoming Period Notification")
                    .setContentText("My Period is Coming!")
                    .setSmallIcon(R.drawable.ic_egg);
        }
        else{//API less than 26 set priority on notification... not using a channel

            notificationBuilder =
                    new NotificationCompat.Builder(this)
                            .setPriority(IMPORTANCE_LEVEL)
                            .setContentTitle("Upcoming Period Notification")
                            .setContentText("Aunty flo is on her way!")
                            .setSmallIcon(R.drawable.ic_egg);
        }

        notificationBuilder.setContentIntent(pendingIntent);
        notificationManager.notify(NOTIFICATION_ID_0, notificationBuilder.build());

        Log.d(TAG, "end of sendNotification method");
    }

    //notifications
    public void notifyButtonClicked(View view) {
        Log.d(TAG, "inside notifyButtonClicked method");
        sendNotification();
        Log.d(TAG, "end of notifyButtonClicked method");
    }
}