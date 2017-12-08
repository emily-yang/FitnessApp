package edu.csulb.android.fitnessapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by joannato on 12/7/17.
 */

public class WorkoutHelper extends SQLiteOpenHelper {

    public WorkoutHelper (Context context)
    {
        super(context, WorkoutContract.DB_NAME, null, WorkoutContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + WorkoutContract.WorkoutEntry.TABLE + "(" +
                WorkoutContract.WorkoutEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                WorkoutContract.WorkoutEntry.WORKOUT_COL_NAME + " TEXT NOT NULL," +
                WorkoutContract.WorkoutEntry.WORKOUT_COL_DAY + " TEXT,"+
                WorkoutContract.WorkoutEntry.WORKOUT_COL_NUM_OF_EXERCISE + " TEXT, " +
                WorkoutContract.WorkoutEntry.WORKOUT_COL_LAST_DATE + " TEXT); ";

        db.execSQL(createTable);
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + WorkoutContract.WorkoutEntry.TABLE);
        onCreate(db);
    }
}
