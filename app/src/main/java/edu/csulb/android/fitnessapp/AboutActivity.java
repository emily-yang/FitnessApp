package edu.csulb.android.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_about, frameLayout);
        mDrawerList.setItemChecked(position, true);
    }
}
