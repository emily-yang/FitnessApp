package edu.csulb.android.fitnessapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class myEventsPlanned extends Fragment{

    private EventListViewModel viewModel;
    private ListViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    public myEventsPlanned() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       // recyclerView = (RecyclerView) recyclerView.findViewById(R.id.recycler_view);
        // recyclerViewAdapter = new ListViewAdapter(new ArrayList<Event>());
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        recyclerView.setAdapter(recyclerViewAdapter);
//        viewModel = ViewModelProviders.of(this).get(EventListViewModel.class);
//        viewModel.getEventList().observe(myEventsPlanned.this, new Observer<List<Event>>() {
//            @Override
//            public void onChanged(@Nullable List<Event> events) {
//                recyclerViewAdapter.addEvents(events); // addItems?;;
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.custom_event_fragment_planned, container, false);

    }

}