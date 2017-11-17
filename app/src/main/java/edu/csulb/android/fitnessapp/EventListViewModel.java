package edu.csulb.android.fitnessapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class EventListViewModel extends AndroidViewModel{

    private final LiveData<List<Event>> eventList;
    private AppDatabase appDatabase;

    public EventListViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
        eventList = appDatabase.eventDao().getAllEvents();
    }

    public LiveData<List<Event>> getEventList() {
        return eventList;
    }
}
