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

public class myEventsActivity extends AppCompatActivity {

    private EventListViewModel viewModel;
    private ListViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);

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
