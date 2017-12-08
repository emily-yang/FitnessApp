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
import java.util.Date;
import java.util.List;


public class myEventsPlanned extends Fragment{

    private EventListViewModel viewModel;
    private ListViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    private List<Event> list;

    public myEventsPlanned() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        list = new ArrayList<>();

        list.add(new Event("Sample", new Date(20180202) , "Beginner", "SampleSample"));


        //BUG FOUND
//        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.recycler_view);
//        recyclerViewAdapter = new ListViewAdapter(list);
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

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.custom_event_fragment_planned, container, false);



    }

}