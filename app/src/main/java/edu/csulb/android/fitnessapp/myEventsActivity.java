package edu.csulb.android.fitnessapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class myEventsActivity extends BaseActivity {
  
    private EventListViewModel viewModel;
    private ListViewAdapter recyclerViewAdapter;
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
        recyclerViewAdapter = new ListViewAdapter(new ArrayList<Event>());
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
}
