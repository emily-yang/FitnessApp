package edu.csulb.android.fitnessapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;
import java.util.List;

@Entity(tableName = "workouts")
public class Workout {
    @PrimaryKey
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "days")
//    @TypeConverters(DateConverter.class)
    private List<Integer> days;

    @ColumnInfo(name = "reps")
    private String reps;

    @ColumnInfo(name = "weight")
    private int weight;

    public Workout(String name, List<Integer> days, String reps, int weight) {
        this.name = name;
        this.days = days;
        this.reps = reps;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getDays() {
        return days;
    }

    public void setDays(List<Integer> days) {
        this.days = days;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
