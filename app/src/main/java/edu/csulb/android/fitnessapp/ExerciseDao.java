package edu.csulb.android.fitnessapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ExerciseDao {
    @Query("SELECT * FROM Exercise")
    LiveData<List<Exercise>> getAllExercises();

    @Query("SELECT * FROM Exercise WHERE day = :day")
    LiveData<List<Exercise>> getExerciseByDay(int day);

    @Insert(onConflict=REPLACE)
    void addExercise(Exercise exercise);

    @Delete
    void deleteExercise(Exercise exercise);
}
