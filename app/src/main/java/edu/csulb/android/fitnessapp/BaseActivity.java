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
     *   Clicking on menu-icon or the hamburger looking icon will reveal the navigation drawer
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




