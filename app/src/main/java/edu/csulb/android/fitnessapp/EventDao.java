package edu.csulb.android.fitnessapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters(DateConverter.class)
public interface EventDao {

    @Query("SELECT * FROM events")
    LiveData<List<Event>> getAllEvents();

    @Query("SELECT * FROM events WHERE id = :eventId")
    Event getEventById(String eventId);

    @Query("SELECT * FROM events WHERE event_name IN (:eventName)")
    Event getEventByName(String eventName);

    @Query("SELECT * FROM events WHERE event_name LIKE :eventName")
    List<Event> getAllEventsWithName(String eventName);

    @Insert(onConflict=REPLACE)
    void addEvent(Event event);

    @Delete
    void deleteEvent(Event event);
}
