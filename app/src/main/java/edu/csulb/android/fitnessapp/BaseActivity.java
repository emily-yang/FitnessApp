package edu.csulb.android.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_home) {
            final Intent viewHome = new Intent(this, MainActivity.class);
            startActivity(viewHome);
            return true;
        }
        if (id == R.id.action_profile) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_workouts) {
            Intent intent = new Intent(this, myWorkoutsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_inspiration) {
            Intent intent = new Intent(this, inspirationActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_events) {
            Intent intent = new Intent(this, myEventsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_logs) {
            Intent intent = new Intent(this, myLogsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
