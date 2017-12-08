package edu.csulb.android.fitnessapp;

import android.provider.BaseColumns;

/**
 * Created by joannato on 12/7/17.
 */

public class WorkoutContract {
    public static final String DB_NAME = "edu.csulb.android.fitnessapp.db";
    public static final int DB_VERSION = 1;

    public class WorkoutEntry implements BaseColumns{
        public static final String TABLE = "Workouts";

        public static final String WORKOUT_COL_NAME = "workout_title";

        public static final String WORKOUT_COL_DAY = "workout_day";
        public static final String WORKOUT_COL_NUM_OF_EXERCISE = "number_of_exercise";
        public static final String WORKOUT_COL_LAST_DATE = "last_date";
    }
}
