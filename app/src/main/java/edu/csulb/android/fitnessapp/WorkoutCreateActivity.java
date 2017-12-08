package edu.csulb.android.fitnessapp;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WorkoutCreateActivity extends BaseActivity {

    EditText exerciseName;
    EditText exerciseReps;
    EditText exerciseWeight;
//    RadioButton radioSun;
//    RadioButton radioMon;
//    RadioButton radioTue;
//    RadioButton radioWed;
//    RadioButton radioThu;
//    RadioButton radioFri;
//    RadioButton radioSat;
//    RadioGroup radioGroup;
    Button saveButton;

    Spinner spinner;

    private String name;
    private String reps;
    private String weight;
    private int day;

    private AddExerciseViewModel addExerciseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts_create);

        exerciseName = findViewById(R.id.exercise_name_field);
        exerciseReps = findViewById(R.id.exercise_reps_field);
        exerciseWeight = findViewById(R.id.exercise_weight_field);
//        radioGroup = findViewById(R.id.radio_group);
//        radioSun = findViewById(R.id.radio_sun);
//        radioMon = findViewById(R.id.radio_mon);
//        radioTue = findViewById(R.id.radio_tue);
//        radioWed = findViewById(R.id.radio_wed);
//        radioThu = findViewById(R.id.radio_thu);
//        radioFri = findViewById(R.id.radio_fri);
//        radioSat = findViewById(R.id.radio_sat);
        spinner = findViewById(R.id.spinner);
        saveButton = findViewById(R.id.exercise_button);

        List<String> list = new ArrayList<String>();
        list.add("Sunday");
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner.setAdapter(adapter);

        addExerciseViewModel = ViewModelProviders.of(this).get(AddExerciseViewModel.class);

        saveButton.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                name = exerciseName.getText().toString();
                reps = exerciseReps.getText().toString();
                weight = exerciseWeight.getText().toString();

//                int radioId = radioGroup.getCheckedRadioButtonId();
//                String radioValue = ((RadioButton)findViewById(radioId)).getText().toString();
//
//                switch(radioValue) {
//                    case "Sunday": day = 1; break;
//                    case "Monday": day = 2; break;
//                    case "Tuesday": day = 3; break;
//                    case "Wednesday": day = 4; break;
//                    case "Thursday": day = 5; break;
//                    case "Friday": day = 6; break;
//                    case "Saturday": day = 7;
//                }

//                if (radioSun.isChecked()) days.add(Calendar.SUNDAY);
//                if (radioMon.isChecked()) days.add(Calendar.MONDAY);
//                if (radioTue.isChecked()) days.add(Calendar.TUESDAY);
//                if (radioWed.isChecked()) days.add(Calendar.WEDNESDAY);
//                if (radioThu.isChecked()) days.add(Calendar.THURSDAY);
//                if (radioFri.isChecked()) days.add(Calendar.FRIDAY);
//                if (radioSat.isChecked()) days.add(Calendar.SATURDAY);


                if (TextUtils.isEmpty(name)  || TextUtils.isEmpty(reps) ||
                        TextUtils.isEmpty(weight))
                    Toast.makeText(WorkoutCreateActivity.this,
                            "Please complete all fields",
                            Toast.LENGTH_SHORT).show();
                else {
                    String selected = String.valueOf(spinner.getSelectedItem());
                    switch(selected) {
                        case "Sunday": day = 1; break;
                        case "Monday": day = 2; break;
                        case "Tuesday": day = 3; break;
                        case "Wednesday": day = 4; break;
                        case "Thursday": day = 5; break;
                        case "Friday": day = 6; break;
                        case "Saturday": day = 7;
                    }

                    Exercise exercise = new Exercise();
                    exercise.setName(name);
                    exercise.setReps(reps);
                    exercise.setWeight(Integer.parseInt(weight));
                    exercise.setDay(day);
                    addExerciseViewModel.addExercise(exercise);
                    Log.w("workoutcreate", "saved!");

                    finish();
                }
            }
        }));

    }
}
