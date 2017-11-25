package edu.csulb.android.fitnessapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class BaseActivity extends NavActivity {

    private ImageButton menuButton;

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

        //To be able to display the navigation drawer
        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);
        mDrawerList.setItemChecked(position, true);

        //To use the custom action bar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_app_bar);
        View view = getSupportActionBar().getCustomView();
    }

    /*
    Clicking on menu-icon or the hamburger looking icon will reveal the navigation drawer
     */
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_icon:
                Toast.makeText(getApplicationContext(), "clicked for placeholder", Toast.LENGTH_LONG).show();
                if(mDrawerLayout.isDrawerOpen(mDrawerList)){
                    mDrawerLayout.closeDrawer(mDrawerList);
                }
                else {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
                break;
            }

    }
}




