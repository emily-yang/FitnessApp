package edu.csulb.android.fitnessapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Event.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract EventDao eventDao();
    public abstract ExerciseDao exerciseDao();

    private static AppDatabase EVENT_INSTANCE;
    private static AppDatabase EXERCISE_INSTANCE;

    public static AppDatabase getEventDatabase(Context context) {
        if (EVENT_INSTANCE == null) {
            EVENT_INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "events").build();
        }
        return EVENT_INSTANCE;
    }
    public static void destroyEventInstance() {
        EVENT_INSTANCE = null;
    }

    public static AppDatabase getExerciseDatabase(Context context) {
        if (EXERCISE_INSTANCE == null) {
            EXERCISE_INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "exercises").build();
        }
        return EXERCISE_INSTANCE;
    }
    public static void destroyExerciseInstance() {
        EXERCISE_INSTANCE = null;
    }
}
