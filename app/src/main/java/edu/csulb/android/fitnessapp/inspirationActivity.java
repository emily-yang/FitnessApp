package edu.csulb.android.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class inspirationActivity extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_home) {
            final Intent viewHome = new Intent(this, MainActivity.class);
            startActivity(viewHome);
            return true;
        }
        if (id == R.id.action_account) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.tiger,R.drawable.tiger,R.drawable.tiger,R.drawable.tiger/*,R.drawable.tiger,R.drawable.tiger,R.drawable.tiger,R.drawable.tiger,R.drawable.tiger,R.drawable.tiger*/};
    public static String [] prgmNameList={"Squats","Bench Press","Bent Over Row","Barbell Shrugs"/*,"Tricep Extensions","Straight Bar","Cable Crunches", "Deadlift", "Standing Press", "Close Grip Bench Press", "Incline Curls"*/};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration);
        context=this;

        lv=(ListView) findViewById(R.id.list);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

    }
}
