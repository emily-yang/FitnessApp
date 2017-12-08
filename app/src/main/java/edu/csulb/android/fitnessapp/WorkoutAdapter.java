package edu.csulb.android.fitnessapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Exercise> exercises;

    private class ViewHolder {
        TextView nameView;
        TextView repsView;
        TextView weightView;
        TextView dayView;
    }

    public WorkoutAdapter(Context context, ArrayList<Exercise> exercises) {
        inflater = LayoutInflater.from(context);
        this.exercises = exercises;
    }

    public int getCount() {
        return exercises.size();
    }

    public Exercise getItem(int position) {
        return exercises.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_fragment, null);
            holder.nameView = (TextView) convertView.findViewById(R.id.listItemName);
            holder.dayView = (TextView) convertView.findViewById(R.id.listItemDay);
            holder.repsView = (TextView) convertView.findViewById(R.id.listItemReps);
            holder.weightView = (TextView) convertView.findViewById(R.id.listItemWeight);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.nameView.setText(exercises.get(position).getName());
        holder.dayView.setText(exercises.get(position).getDay());
        holder.repsView.setText(exercises.get(position).getReps());
        holder.weightView.setText(exercises.get(position).getWeight());
        return convertView;
    }

}
