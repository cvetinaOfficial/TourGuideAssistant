package com.tourguideassistant.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.bean.UserPreferenceBean;

import java.util.List;

@Dao
public interface UserPreferenceDao {

    @Insert
    void insertUserPreference(UserPreferenceBean userPreferenceBean);

    @Delete
    void deleteUserPreference(UserPreferenceBean userPreferenceBean);

    @Update
    void updateUserPreference(UserPreferenceBean userPreferenceBean);

    @Transaction
    @Query("SELECT * FROM user_preference WHERE userId = :id")
    public List<UserPreferenceBean> findUserPreferenceByUserId(int id);

    @Transaction
    @Query("SELECT * FROM user_preference")
    List<UserPreferenceBean> getAllUserPreferences();
}
