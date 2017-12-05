package edu.csulb.android.fitnessapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Event.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase EVENT_INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (EVENT_INSTANCE == null) {
            EVENT_INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "events").build();
        }
        return EVENT_INSTANCE;
    }

    public static void destroyEventInstance() {
        EVENT_INSTANCE = null;
    }
    public abstract EventDao eventDao();
}
