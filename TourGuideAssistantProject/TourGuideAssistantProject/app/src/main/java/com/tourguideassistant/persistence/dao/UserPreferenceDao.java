package com.tourguideassistant.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.persistence.entity.UserPreferenceEntity;

import java.util.List;

@Dao
public interface UserPreferenceDao {

    @Insert
    void insertUserPreference(UserPreferenceEntity userPreferenceEntity);

    @Delete
    void deleteUserPreference(UserPreferenceEntity userPreferenceEntity);

    @Update
    void updateUserPreference(UserPreferenceEntity userPreferenceEntity);

    @Transaction
    @Query("SELECT * FROM user_preference WHERE userId = :id")
    public UserPreferenceEntity findUserPreferenceByUserId(int id);

    @Transaction
    @Query("SELECT * FROM user_preference")
    LiveData<List<UserPreferenceEntity>> getAllUserPreferences();

    @Transaction
    @Query("SELECT * FROM user_preference WHERE id = :id")
    public LiveData<UserPreferenceEntity> loadUserPreferenceById(int id);
}
