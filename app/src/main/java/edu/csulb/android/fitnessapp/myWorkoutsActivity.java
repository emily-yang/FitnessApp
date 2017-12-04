package edu.csulb.android.fitnessapp;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class myWorkoutsActivity extends BaseActivity {

    private List<Workouts> workoutsList;
    private ListView rv;
    WorkoutAdapter workoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDrawerList.setItemChecked(position,true);

        getLayoutInflater().inflate(R.layout.activity_workouts, frameLayout);

        initializeData();

        rv = (ListView) findViewById(R.id.workout_list_view);
        workoutAdapter = new WorkoutAdapter(this, workoutsList);

        rv.setAdapter(workoutAdapter);


    }

    private void initializeData(){
        workoutsList = new ArrayList<>();
        workoutsList.add(new Workouts("Legs", "Monday", "06"));
        workoutsList.add(new Workouts("Arms", "Wednesday", "05"));
        workoutsList.add(new Workouts("Chest", "Friday", "05"));
        workoutsList.add(new Workouts("Cardio", "Sunday, Saturday", "05"));

    }

}




