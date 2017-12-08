package edu.csulb.android.fitnessapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class myEventsActivity extends BaseActivity implements View.OnLongClickListener {
  
    private EventListViewModel viewModel;
    private EventListAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //To be able to display the navigation drawer
        getLayoutInflater().inflate(R.layout.activity_my_events, frameLayout);
        mDrawerList.setItemChecked(position, true);

        Button button = (Button) findViewById(R.id.add_event_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(myEventsActivity.this, AddEventActivity.class));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerViewAdapter = new EventListAdapter(new ArrayList<Event>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerViewAdapter);
        viewModel = ViewModelProviders.of(this).get(EventListViewModel.class);
        viewModel.getEventList().observe(myEventsActivity.this, new Observer<List<Event>>() {
            @Override
            public void onChanged(@Nullable List<Event> events) {
                recyclerViewAdapter.addEvents(events); // addItems?
            }
        });


    }

    @Override
    public boolean onLongClick(View v) {
        Event event = (Event) v.getTag();
        viewModel.deleteEvent(event);
        return true;
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyEventInstance();
        super.onDestroy();
    }
}
