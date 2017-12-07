package edu.csulb.android.fitnessapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

public class AddExerciseViewModel extends AndroidViewModel{

    private AppDatabase exerciseDatabase;

    public AddExerciseViewModel(Application app) {
        super(app);
        exerciseDatabase = AppDatabase.getExerciseDatabase(this.getApplication());
    }

    public void addExercise(Exercise exercise) {
        new AddExerciseAsyncTask(exerciseDatabase).execute(exercise);
    }

    private static class AddExerciseAsyncTask extends AsyncTask<Exercise, Void, Void> {
        private AppDatabase db;

        public AddExerciseAsyncTask(AppDatabase appDatabase) { db = appDatabase;}

        @Override
        protected Void doInBackground(Exercise... params) {
            db.exerciseDao().addExercise(params[0]);
            return null;
        }
    }
}
