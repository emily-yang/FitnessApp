package edu.csulb.android.fitnessapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class EventListViewModel extends AndroidViewModel{

    private final LiveData<List<Event>> eventList;
    private AppDatabase eventDatabase;

    public EventListViewModel(Application application) {
        super(application);
        eventDatabase = AppDatabase.getEventDatabase(this.getApplication());
        eventList = eventDatabase.eventDao().getAllEvents();
    }

    public LiveData<List<Event>> getEventList() {
        return eventList;
    }

    public void deleteEvent(Event event) {
        new deleteAsyncTask(eventDatabase).execute(event);
    }

    private static class deleteAsyncTask extends AsyncTask<Event, Void, Void> {
        private AppDatabase db;

        deleteAsyncTask(AppDatabase eventDatabase) {
            db = eventDatabase;
        }

        @Override
        protected Void doInBackground(final Event... params) {
            db.eventDao().deleteEvent(params[0]);
            return null;
        }
    }
}
