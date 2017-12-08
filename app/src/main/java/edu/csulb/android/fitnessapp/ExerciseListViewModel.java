package edu.csulb.android.fitnessapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ExerciseListViewModel extends AndroidViewModel {
    private final LiveData<List<Exercise>> exerciseList;
    private AppDatabase exerciseDatabase;

    public ExerciseListViewModel(Application app) {
        super(app);
        exerciseDatabase = AppDatabase.getExerciseDatabase(this.getApplication());
        exerciseList = exerciseDatabase.exerciseDao().getAllExercises();
    }

    public LiveData<List<Exercise>> getExerciseList() { return exerciseList; }

    public void deleteExercise(Exercise exercise) {
        new ExerciseListViewModel.deleteAsyncTask(exerciseDatabase).execute(exercise);
    }

    private static class deleteAsyncTask extends AsyncTask<Exercise, Void, Void> {
        private AppDatabase db;

        deleteAsyncTask(AppDatabase exerciseDatabase) {
            db = exerciseDatabase;
        }

        @Override
        protected Void doInBackground(final Exercise... params) {
            db.exerciseDao().deleteExercise(params[0]);
            return null;
        }
    }

}
