package com.tourguideassistant.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.tourguideassistant.persistence.entity.UserHistoryEntity;

import java.util.List;

@Dao
public interface UserHistoryDao {

    @Insert
    void insertUserHistory(UserHistoryEntity userHistoryEntity);

    @Delete
    void deleteUserHistory(UserHistoryEntity userHistoryEntity);

    @Transaction
    @Query("SELECT * FROM user_history")
    LiveData<List<UserHistoryEntity>> getUserHistory();
}
