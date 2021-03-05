package com.tourguideassistant.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.persistence.entity.UpcomingTripEntity;
import com.tourguideassistant.persistence.entity.UpcomingTripWithLandmarks;

import java.util.List;

@Dao
public interface UpcomingTripDao {

    @Insert
    void insertUpcomingTrip(UpcomingTripEntity upcomingTripEntity);

    @Delete
    void deleteUpcomingTrip(UpcomingTripEntity upcomingTripEntity);

    @Update
    void updateCategory(UpcomingTripEntity upcomingTripEntity);

    @Transaction
    @Query("SELECT * FROM upcomingTrip")
    List<UpcomingTripEntity> getAllUpcomingTrips();

    @Transaction
    @Query("SELECT * FROM upcomingTrip WHERE Id = :Id")
    public UpcomingTripEntity findUpcomingTripById(int Id);

    @Transaction
    @Query("SELECT * FROM upcomingTrip WHERE id = :id")
    public LiveData<UpcomingTripEntity> loadUpcomingTripById(int id);

    @Transaction
    @Query("SELECT * FROM upcomingTrip")
    public List<UpcomingTripWithLandmarks> getUpcomingTripsWithLandmarks();
}
