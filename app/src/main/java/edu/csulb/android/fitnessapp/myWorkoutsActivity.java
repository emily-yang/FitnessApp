package edu.csulb.android.fitnessapp;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class myWorkoutsActivity extends BaseActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter rvAdapter;
    FloatingActionButton actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //actionButton = (FloatingActionButton) findViewById(R.id.add_button);

        getLayoutInflater().inflate(R.layout.activity_workouts, frameLayout);
        mDrawerList.setItemChecked(position, true);
        //recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //layoutManager = new LinearLayoutManager(this);

        //recyclerView.setLayoutManager(layoutManager);

        //rvAdapter = new RecyclerAdapter();
        //recyclerView.setAdapter(rvAdapter);
    }

}
