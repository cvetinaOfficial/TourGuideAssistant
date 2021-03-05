package com.tourguideassistant.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.persistence.entity.LandmarkEntity;

import java.util.List;

@Dao
public interface LandmarkDao {
    @Insert
    void insertLandmark(LandmarkEntity landmarkEntity);

    @Delete
    void deleteLandmark(LandmarkEntity landmarkEntity);

    @Update
    void updateLandmark(LandmarkEntity landmarkEntity);

    @Transaction
    @Query("SELECT * FROM landmark")
    List<LandmarkEntity> getAllLandmarks();

    @Transaction
    @Query("SELECT * FROM landmark WHERE Id = :id")
    public LandmarkEntity findLandmarkById(int id);

    @Transaction
    @Query("SELECT * FROM landmark WHERE id = :id")
    public LiveData<LandmarkEntity> loadLandmarkById(int id);
}
