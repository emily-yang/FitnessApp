package edu.csulb.android.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joannato on 12/6/17.
 */

public class FindEventsActivity extends BaseActivity {

    ListView lv;
    List<EventCategory> eventCategories;
    FindBrowseAdapter findBrowseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_find_events, frameLayout);

        initializeData();

        lv = (ListView) findViewById(R.id.find_browse_list_view_vertical);
        findBrowseAdapter = new FindBrowseAdapter(this, eventCategories);

        lv.setAdapter(findBrowseAdapter);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_icon:
                finish();
                break;
        }
    }


    private void initializeData(){
        eventCategories = new ArrayList<>();
        eventCategories.add(new EventCategory("Cycling Events", R.drawable.browse_sample));
        eventCategories.add(new EventCategory("Powerlifting Events", R.drawable.browse_sample));
        eventCategories.add(new EventCategory("Marathon Events", R.drawable.browse_sample));

    }


}






