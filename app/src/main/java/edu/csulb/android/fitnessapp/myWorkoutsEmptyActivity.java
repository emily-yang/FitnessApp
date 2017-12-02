package edu.csulb.android.fitnessapp;

import android.view.View;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/*
When there is no workouts created in the the database, this activity should be loaded. Vice versa
this activity should disappear once a workout is created and added to the database
 */

public class myWorkoutsEmptyActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDrawerList.setItemChecked(position, true);

        View screen = getLayoutInflater().inflate(R.layout.no_workout, frameLayout);

    }
}
