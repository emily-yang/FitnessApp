package edu.csulb.android.fitnessapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class BaseActivity extends NavActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //To be able to display the navigation drawer
        getLayoutInflater().inflate(R.layout.activity_base, frameLayout);
        mDrawerList.setItemChecked(position, true);

        toolbar = (Toolbar) findViewById( R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    /*
     *   Clicking on menu_events-icon or the hamburger looking icon will reveal the navigation drawer
     */
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_icon:
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




