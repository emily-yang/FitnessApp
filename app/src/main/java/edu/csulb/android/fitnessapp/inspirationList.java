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
    ListView lv;
    Context context;

    public static int[] prgmImages = {
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend,
            R.drawable.fitfriend
    };

    public static String[] prgmNameList = {
            "Squats",
            "Bench Press",
            "Bent Over Row",
            "Barbell Shrugs",
            "Tricep Extensions",
            "Straight Bar",
            "Cable Crunches",
            "Deadlift",
            "Standing Press",
            "Pull Ups",
            "Sit Ups",
            "Push Ups",
            "Curls",
            "Dips",
            "Downward Dog",
            "Sun Salutation",
            "Warrior I",
            "Warrior II",
            "Run",
            "Jumping Jacks",
            "Jump Rope",
            "High Knees"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration_list);


        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new inspirationAdapter(this, prgmNameList, prgmImages));
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_icon:
                finish();
                break;
        }
    }
}


