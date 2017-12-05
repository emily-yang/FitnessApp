package edu.csulb.android.fitnessapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class EventListViewModel extends AndroidViewModel{

    private final LiveData<List<Event>> eventList;
    private AppDatabase eventDatabase;

    public EventListViewModel(Application application) {
        super(application);
        eventDatabase = AppDatabase.getDatabase(this.getApplication());
        eventList = eventDatabase.eventDao().getAllEvents();
    }

    public LiveData<List<Event>> getEventList() {
        return eventList;
    }
}
