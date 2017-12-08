package edu.csulb.android.fitnessapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.RecyclerViewHolder>{

    private View.OnLongClickListener longClickListener;
    private List<Exercise> exerciseList;

    public ExerciseListAdapter(List<Exercise> exerciseList, View.OnLongClickListener longClickListener) {
        this.exerciseList = exerciseList;
        this.longClickListener = longClickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ExerciseListAdapter.RecyclerViewHolder holder, int position) {
        Exercise exercise = exerciseList.get(position);
        int day = exercise.getDay();
        String dayStr="";
        switch(day) {
            case 1: dayStr = "Sun"; break;
            case 2: dayStr = "Mon"; break;
            case 3: dayStr = "Tue"; break;
            case 4: dayStr = "Wed"; break;
            case 5: dayStr = "Thu"; break;
            case 6: dayStr = "Fri"; break;
            case 7: dayStr = "Sat";

        }
        holder.exerciseItemName.setText(exercise.getName());
        holder.exerciseItemDay.setText(dayStr);
        holder.exerciseItemReps.setText(exercise.getReps());
        holder.exerciseItemWeight.setText(String.valueOf(exercise.getWeight()) + "lb");
        holder.itemView.setTag(exercise);
        holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public void addExercises(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView exerciseItemName;
        private TextView exerciseItemReps;
        private TextView exerciseItemWeight;
        private TextView exerciseItemDay;

        RecyclerViewHolder(View v){
            super(v);
            exerciseItemName = v.findViewById(R.id.exercise_item_name);
            exerciseItemReps = v.findViewById(R.id.exercise_item_reps);
            exerciseItemWeight = v.findViewById(R.id.exercise_item_weight);
            exerciseItemDay = v.findViewById(R.id.exercise_item_day);
        }

    }
}
