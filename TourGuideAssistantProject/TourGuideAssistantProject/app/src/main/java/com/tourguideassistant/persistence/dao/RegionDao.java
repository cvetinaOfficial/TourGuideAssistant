package com.tourguideassistant.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.persistence.entity.RegionEntity;

import java.util.List;

@Dao
public interface RegionDao {
    @Insert
    void insertRegion(RegionEntity regionEntity);

    @Delete
    void deleteRegion(RegionEntity regionEntity);

    @Update
    void updateRegion(RegionEntity regionEntity);

    @Transaction
    @Query("SELECT * FROM region")
    List<RegionEntity> getAllRegions();

    @Transaction
    @Query("SELECT * FROM region WHERE Id = :id")
    public RegionEntity findRegionById(int id);

    @Transaction
    @Query("SELECT * FROM region WHERE id = :id")
    public LiveData<RegionEntity> loadRegionById(int id);
}
