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


    }
}

