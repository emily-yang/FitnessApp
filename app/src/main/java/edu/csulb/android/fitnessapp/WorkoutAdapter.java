package edu.csulb.android.fitnessapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutAdapter extends ArrayAdapter<Workouts>{

        List<Workouts> workouts;
        View view;
        //Get the context
        Context mContext = null;
        int resource;
        WorkoutViewHolder viewHolder;

    public WorkoutAdapter (Context context, int resource, ArrayList<Workouts> wList)
    {
        super(context, resource,wList);
        mContext = context;
        this.resource = resource;
        workouts = wList;
    }

    @Override
    public int getCount() {
        return workouts.size();
    }

    @Override
    public Workouts getItem(int position) {
        return workouts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
       Workouts workouts = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.activity_workout_card, viewGroup, false);
        }
        // Lookup view for data population
        WorkoutViewHolder wvh = new WorkoutViewHolder(view);

        // Populate the data into the template view using the data object
        wvh.workoutTitle.setText(workouts.getWorkoutName());
        wvh.workoutDay.setText(workouts.getDayOfTheWeek());
        wvh.numOfWorkouts.setText(workouts.getNumberOfWorkouts());
        wvh.date.setText(workouts.getLastDate());

        // Return the completed view to render on screen
        return view;
    }


    public class WorkoutViewHolder{

            TextView workoutTitle;
            TextView workoutDay;
            TextView numOfWorkouts;
            TextView date;

            public WorkoutViewHolder(View itemView) {

                workoutTitle = (TextView)itemView.findViewById(R.id.card_title);
                workoutDay = (TextView)itemView.findViewById(R.id.week_day);
                numOfWorkouts = (TextView) itemView.findViewById(R.id.number_workout);
                date = (TextView)itemView.findViewById(R.id.date_text);

            }



        }


    }

