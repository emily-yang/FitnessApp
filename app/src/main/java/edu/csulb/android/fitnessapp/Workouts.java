package edu.csulb.android.fitnessapp;

/**
 * Created by joannato on 12/3/17.
 */

public class Workouts {

    private String workoutName;
    private String dayOfTheWeek;
    private String numberOfWorkouts;
    private String lastDate;

    public Workouts(String workoutName, String dayOfTheWeek, String numberOfWorkouts,String lastDate) {
        this.workoutName = workoutName;
        this.dayOfTheWeek = dayOfTheWeek;
        this.numberOfWorkouts = numberOfWorkouts;
        this.lastDate = lastDate;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public String getNumberOfWorkouts() {
        return numberOfWorkouts;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setWorkoutName(String name){
        workoutName = name;
    }

    public void setDayOfTheWeek(String day){
        dayOfTheWeek = day;
    }

    public void setNumberOfWorkouts(String num){
        numberOfWorkouts = num;
    }

    public void setLastDate(String date){
        lastDate = date;
    }


}

