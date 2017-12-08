package edu.csulb.android.fitnessapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class WorkoutCreateActivity extends BaseActivity {

    private Button addButton;
    private EditText workoutTitle, workoutDay, numberExercises, lastWorkout;
    private WorkoutHelper workoutHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts_create);

        addButton = (Button) findViewById(R.id.wC_addButton);
        workoutTitle = (EditText) findViewById(R.id.workout_title);
        workoutDay = (EditText) findViewById(R.id.workout_day);
        numberExercises = (EditText) findViewById(R.id.number_of_workout);
        lastWorkout = (EditText) findViewById(R.id.last_date);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addData();
                Intent getWorkouts = new Intent(WorkoutCreateActivity.this, myWorkoutsActivity.class);
                startActivity(getWorkouts);
            }
        });



    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_icon:
               finish();
                break;
        }
    }

    public void addData()
    {
        workoutHelper = new WorkoutHelper(WorkoutCreateActivity.this);
        SQLiteDatabase db = workoutHelper.getWritableDatabase();

        String workout_title_text = workoutTitle.getText().toString();
        String workout_day_text = workoutDay.getText().toString();
        String number_of_workouts_text = numberExercises.getText().toString();
        String last_date_text = lastWorkout.getText().toString();

        ContentValues values = new ContentValues();
        values.put(WorkoutContract.WorkoutEntry.WORKOUT_COL_NAME,workout_title_text);
        values.put(WorkoutContract.WorkoutEntry.WORKOUT_COL_DAY,workout_day_text);
        values.put(WorkoutContract.WorkoutEntry.WORKOUT_COL_NUM_OF_EXERCISE,number_of_workouts_text);
        values.put(WorkoutContract.WorkoutEntry.WORKOUT_COL_LAST_DATE,last_date_text);

        db.insertWithOnConflict(WorkoutContract.WorkoutEntry.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);

        String count = "SELECT count(*) FROM " + WorkoutContract.WorkoutEntry.TABLE;
        Cursor cursor1 = db.rawQuery(count, null);

        cursor1.moveToFirst();
        int icount = cursor1.getInt(0);

        Log.d("createworkoutactivity", "number of entrys " + icount );

        db.close();

    }
}
