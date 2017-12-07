package edu.csulb.android.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WorkoutCreateActivity extends BaseActivity {

    EditText exerciseName;
    EditText exerciseReps;
    EditText exerciseWeight;
    CheckBox boxSun;
    CheckBox boxMon;
    CheckBox boxTue;
    CheckBox boxWed;
    CheckBox boxThu;
    CheckBox boxFri;
    CheckBox boxSat;
    Button saveButton;

    private String name;
    private String reps;
    private String weight;

    private List<Integer> days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts_create);

        exerciseName = findViewById(R.id.exercise_name_field);
        exerciseReps = findViewById(R.id.exercise_reps_field);
        exerciseWeight = findViewById(R.id.exercise_weight_field);
        boxSun = findViewById(R.id.checkbox_sun);
        boxMon = findViewById(R.id.checkbox_mon);
        boxTue = findViewById(R.id.checkbox_tue);
        boxWed = findViewById(R.id.checkbox_wed);
        boxThu = findViewById(R.id.checkbox_thu);
        boxFri = findViewById(R.id.checkbox_fri);
        boxSat = findViewById(R.id.checkbox_sat);
        saveButton = findViewById(R.id.exercise_button);

        saveButton.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                days = new ArrayList();

                name = exerciseName.getText().toString();
                reps = exerciseReps.getText().toString();
                weight = exerciseWeight.getText().toString();

                if (boxSun.isChecked()) days.add(Calendar.SUNDAY);
                if (boxMon.isChecked()) days.add(Calendar.MONDAY);
                if (boxTue.isChecked()) days.add(Calendar.TUESDAY);
                if (boxWed.isChecked()) days.add(Calendar.WEDNESDAY);
                if (boxThu.isChecked()) days.add(Calendar.THURSDAY);
                if (boxFri.isChecked()) days.add(Calendar.FRIDAY);
                if (boxSat.isChecked()) days.add(Calendar.SATURDAY);

                if (TextUtils.isEmpty(name)  || TextUtils.isEmpty(reps) ||
                        TextUtils.isEmpty(weight) || days.isEmpty())
                    Toast.makeText(WorkoutCreateActivity.this,
                            "Please complete all fields",
                            Toast.LENGTH_SHORT).show();
                else {

                    // save exercise

                    finish();
                }
            }
        }));

    }
}
