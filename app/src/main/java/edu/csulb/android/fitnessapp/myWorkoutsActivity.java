package edu.csulb.android.fitnessapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class myWorkoutsActivity extends BaseActivity implements View.OnLongClickListener{

    private ExerciseListViewModel viewModel;
    private ExerciseListAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //To be able to display the navigation drawer
        getLayoutInflater().inflate(R.layout.activity_workouts, frameLayout);
        mDrawerList.setItemChecked(position, true);

        Button button = (Button) findViewById(R.id.add_exercise_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(myWorkoutsActivity.this, WorkoutCreateActivity.class));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        recyclerViewAdapter = new ExerciseListAdapter(new ArrayList<Exercise>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerViewAdapter);
        viewModel = ViewModelProviders.of(this).get(ExerciseListViewModel.class);
        viewModel.getExerciseList().observe(myWorkoutsActivity.this, new Observer<List<Exercise>>() {
            @Override
            public void onChanged(@Nullable List<Exercise> exercises) {
                recyclerViewAdapter.addExercises(exercises);
            }
        });


    }

    @Override
    public boolean onLongClick(View v) {
        Exercise exercise = (Exercise) v.getTag();
        viewModel.deleteExercise(exercise);
        return true;
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyExerciseInstance();
        super.onDestroy();
    }
}


