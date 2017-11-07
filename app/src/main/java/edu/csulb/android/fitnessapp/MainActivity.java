package edu.csulb.android.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button myWorkouts;
    private Button myEvents;
    private Button inspiration;
    private Button myLogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent getWorkouts = new Intent(this, myWorkoutsActivity.class);
        myWorkouts = (Button)findViewById(R.id.myWorkouts);
        myWorkouts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getWorkouts);
            }
        });

        final Intent getEvents = new Intent(this, myEventsActivity.class);
        myEvents = (Button)findViewById(R.id.myEvents);
        myEvents.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getEvents);
            }
        });

        final Intent getInspiration = new Intent(this, inspirationActivity.class);
        inspiration = (Button)findViewById(R.id.inspiration);
        inspiration.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getInspiration);
            }
        });

        final Intent getLogs = new Intent(this, myLogsActivity.class);
        myLogs = (Button)findViewById(R.id.myLogs);
        myLogs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getLogs);
            }
        });
    }
}
