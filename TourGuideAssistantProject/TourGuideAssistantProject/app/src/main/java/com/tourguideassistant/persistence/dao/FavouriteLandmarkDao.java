package com.tourguideassistant.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.persistence.entity.FavouriteLandmarkEntity;

import java.util.List;

@Dao
public interface FavouriteLandmarkDao {
    @Insert
    void insertFavouriteLandmark(FavouriteLandmarkEntity favouriteLandmarkEntity);

    @Delete
    void deleteFavouriteLandmark(FavouriteLandmarkEntity favouriteLandmarkEntity);

    @Update
    void updateFavouriteLandmark(FavouriteLandmarkEntity favouriteLandmarkEntity);

    @Transaction
    @Query("SELECT * FROM favouriteLandmark")
    List<FavouriteLandmarkEntity> getAllFavouriteLandmarks();

    @Transaction
    @Query("SELECT * FROM favouriteLandmark WHERE Id = :id")
    public FavouriteLandmarkEntity findFavourtiteLandmarkById(int id);

    @Transaction
    @Query("SELECT * FROM favouriteLandmark WHERE id = :id")
    public LiveData<FavouriteLandmarkEntity> loadFavourtiteLandmarkById(int id);
}
