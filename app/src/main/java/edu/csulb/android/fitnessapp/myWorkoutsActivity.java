package edu.csulb.android.fitnessapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class myWorkoutsActivity extends BaseActivity {

    private ArrayList<Workouts> workoutsList;
    private ListView rv;
    WorkoutAdapter workoutAdapter;
    WorkoutHelper workoutHelper;
    View parent;
    TextView workoutTextView;
    String workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateUI();
        mDrawerList.setItemChecked(position,true);


    }
//    @Override
//    protected void onResume(){
//        super.onResume();
//        updateUI();
//    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_icon:
                if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                    mDrawerLayout.closeDrawer(mDrawerList);
                } else {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
                break;

            case R.id.workout_add_button:
                final Intent getWorkouts = new Intent(this, WorkoutCreateActivity.class);
                startActivity(getWorkouts);

                break;

            case R.id.delete_button:
                parent = (View) v.getParent();
                workoutTextView = (TextView) parent.findViewById(R.id.card_title);
                workout = String.valueOf(workoutTextView.getText());

                SQLiteDatabase db = workoutHelper.getWritableDatabase();
                db.delete(WorkoutContract.WorkoutEntry.TABLE,
                        WorkoutContract.WorkoutEntry.WORKOUT_COL_NAME + " = ?",
                        new String[] {workout});
                db.close();
                updateUI();
                break;
        }
    }

    private void updateUI() {
        workoutHelper = new WorkoutHelper(this);
        SQLiteDatabase db = workoutHelper.getReadableDatabase();

        String count = "SELECT count(*) FROM " + WorkoutContract.WorkoutEntry.TABLE;
        Cursor cursor1 = db.rawQuery(count, null);

        cursor1.moveToFirst();
        int icount = cursor1.getInt(0);

        Log.d("createworkoutactivity", "number of entrys " + icount);

        if (icount == 0) {
            getLayoutInflater().inflate(R.layout.no_workout, frameLayout);
        } else {
            getLayoutInflater().inflate(R.layout.activity_workouts, frameLayout);

            workoutsList = new ArrayList<>();
            rv = (ListView) findViewById(R.id.workout_list_view);
            workoutAdapter = new WorkoutAdapter(this, R.layout.activity_workout_card, workoutsList);

            rv.setAdapter(workoutAdapter);


            Log.d("createworkout", "updateUI: " + "UPDATED");
            ArrayList<Workouts> aList = new ArrayList<>();
            Workouts mworkouts;

            Cursor cursor = db.query(WorkoutContract.WorkoutEntry.TABLE,
                    new String[]{
                            WorkoutContract.WorkoutEntry._ID,
                            WorkoutContract.WorkoutEntry.WORKOUT_COL_NAME,
                            WorkoutContract.WorkoutEntry.WORKOUT_COL_DAY,
                            WorkoutContract.WorkoutEntry.WORKOUT_COL_NUM_OF_EXERCISE,
                            WorkoutContract.WorkoutEntry.WORKOUT_COL_LAST_DATE}, null, null, null, null, null);

            while (cursor.moveToNext()) {
                int idx = cursor.getColumnIndex(WorkoutContract.WorkoutEntry.WORKOUT_COL_NAME);
                int idx2 = cursor.getColumnIndex(WorkoutContract.WorkoutEntry.WORKOUT_COL_DAY);
                int idx3 = cursor.getColumnIndex(WorkoutContract.WorkoutEntry.WORKOUT_COL_NUM_OF_EXERCISE);
                int idx4 = cursor.getColumnIndex(WorkoutContract.WorkoutEntry.WORKOUT_COL_LAST_DATE);

                mworkouts = new Workouts(
                        String.valueOf(cursor.getString(idx)),
                        String.valueOf(cursor.getString(idx2)),
                        String.valueOf(cursor.getString(idx3)),
                        String.valueOf(cursor.getString(idx4)));

                aList.add(mworkouts);
            }
            if (workoutAdapter == null) {
                Log.d("createwo", "updateUI: " + "workoutADapter");
                workoutAdapter = new WorkoutAdapter(this, R.layout.activity_workout_card, aList);
                rv.setAdapter(workoutAdapter);
            } else {
                workoutAdapter.clear();
                workoutAdapter.addAll(aList);
                workoutAdapter.notifyDataSetChanged();
            }


            cursor.close();
            db.close();
        }
    }

}




