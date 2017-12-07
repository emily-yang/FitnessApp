package edu.csulb.android.fitnessapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

public class AddEventViewModel extends AndroidViewModel {
    private AppDatabase eventDatabase;

    public AddEventViewModel(Application app) {
        super(app);
        eventDatabase = AppDatabase.getEventDatabase(this.getApplication());
    }

    public void addEvent(Event event) {
        new AddEventAsyncTask(eventDatabase).execute(event);
    }

    private static class AddEventAsyncTask extends AsyncTask<Event, Void, Void> {

        private AppDatabase db;

        public AddEventAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(Event... params) {
            db.eventDao().addEvent(params[0]);
            return null;
        }
    }


}
