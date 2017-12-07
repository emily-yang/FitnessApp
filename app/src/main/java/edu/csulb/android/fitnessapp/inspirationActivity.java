package edu.csulb.android.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class inspirationActivity extends BaseActivity {
    private Button list;

    private Button workout1;
    private Button workout2;
    private Button workout3;
    private Button workout4;
    private Button workout5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //To be able to display the navigation drawer
        getLayoutInflater().inflate(R.layout.activity_inspiration, frameLayout);
        mDrawerList.setItemChecked(position, true);

        final Intent getList = new Intent(this, inspirationList.class);
        list = (Button)findViewById(R.id.list);
        list.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getList);
            }
        });

        final Intent getWorkout1 = new Intent(this, inspirationList.class);
        workout1 = (Button)findViewById(R.id.workout1);
        workout1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getList);
            }
        });

        final Intent getWorkout2 = new Intent(this, inspirationList.class);
        workout2 = (Button)findViewById(R.id.workout2);
        workout2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getList);
            }
        });

        final Intent getWorkout3 = new Intent(this, inspirationList.class);
        workout3 = (Button)findViewById(R.id.workout3);
        workout3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getList);
            }
        });

        final Intent getWorkout4 = new Intent(this, inspirationList.class);
        workout4 = (Button)findViewById(R.id.workout4);
        workout4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getList);
            }
        });

        final Intent getWorkout5 = new Intent(this, inspirationList.class);
        workout5 = (Button)findViewById(R.id.workout5);
        workout5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(getList);
            }
        });

    }
}

