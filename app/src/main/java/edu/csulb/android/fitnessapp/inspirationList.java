package edu.csulb.android.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class inspirationList extends BaseActivity {
    // data to show
    /*List<Map<String,String>> workoutList = new ArrayList<Map<String,String>>();

    public static int[] prgmImages = {R.drawable.fitfriend, R.drawable.fitfriend, R.drawable.fitfriend, R.drawable.fitfriend};

    private void initList() {
        workoutList.add(createWorkout("workout", "Squats"));
        workoutList.add(createWorkout("workout", "Bench Press"));
        workoutList.add(createWorkout("workout", "Bent Over Row"));
        workoutList.add(createWorkout("workout", "Barbell Shrugs"));
    }

    private HashMap<String, String> createWorkout(String key, String name) {
        HashMap<String, String> workout = new HashMap<String, String>();
        workout.put(key, name);
        return workout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration_list);

        initList();

        ListView lv = (ListView) findViewById(R.id.listView);

        simpleAdpt = new SimpleAdapter(this, workoutList, android.R.layout.simple_list_item_1, new String[]{"workout"}, new int[]{android.R.id.text1});

        lv.setAdapter(new inspirationAdapter(this, workoutList, prgmImages));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view,
                                    int position, long id) {

            }
        });
    }*/

    ListView lv;
    Context context;

    public static int[] prgmImages = {R.drawable.fitfriend, R.drawable.fitfriend, R.drawable.fitfriend, R.drawable.fitfriend};
    public static String[] prgmNameList = {"Squats", "Bench Press", "Bent Over Row", "Barbell Shrugs"/*,"Tricep Extensions","Straight Bar","Cable Crunches", "Deadlift", "Standing Press", "Close Grip Bench Press", "Incline Curls"*/};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration_list);


        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new inspirationAdapter(this, prgmNameList, prgmImages));
    }
}


