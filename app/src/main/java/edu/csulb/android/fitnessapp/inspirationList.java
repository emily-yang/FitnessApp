package edu.csulb.android.fitnessapp;

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
    List<Map<String,String>> workoutList = new ArrayList<Map<String,String>>();
    SimpleAdapter simpleAdapter;
    private SimpleAdapter simpleAdpt;

    private void initList() {
        workoutList.add(createWorkout("workout", "Arms"));
        workoutList.add(createWorkout("workout", "Legs"));
        workoutList.add(createWorkout("workout", "Cardio"));
        workoutList.add(createWorkout("workout", "Back"));
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

        lv.setAdapter(simpleAdpt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view,
                                    int position, long id) {

            }
        });
    }
}
