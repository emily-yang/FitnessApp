package edu.csulb.android.fitnessapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private Button myWorkouts;
    private Button myEvents;
    private Button inspiration;
    private Button myLogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final Intent getWorkouts = new Intent(this, myWorkoutsActivity.class);
        myWorkouts = (Button)findViewById(R.id.myWorkouts);
        myWorkouts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getWorkouts);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        final Intent getEvents = new Intent(this, myEventsActivity.class);
        myEvents = (Button)findViewById(R.id.myEvents);
        myEvents.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getEvents);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        final Intent getInspiration = new Intent(this, inspirationActivity.class);
        inspiration = (Button)findViewById(R.id.inspiration);
        inspiration.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getInspiration);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        final Intent getLogs = new Intent(this, myLogsActivity.class);
        myLogs = (Button)findViewById(R.id.myLogs);
        myLogs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getLogs);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}
