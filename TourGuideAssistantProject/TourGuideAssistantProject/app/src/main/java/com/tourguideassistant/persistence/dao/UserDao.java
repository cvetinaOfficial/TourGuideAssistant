package com.tourguideassistant.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.persistence.entity.UserAndHistory;
import com.tourguideassistant.persistence.entity.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

    @Transaction
    @Query("SELECT * FROM user")
    LiveData<List<UserEntity>> getAllUsers();

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insertUser(UserEntity userEntity);

    @Delete
    void deleteUser(UserEntity userEntity);

    @Update
    void updateUser(UserEntity userEntity);

    @Query("SELECT * FROM user WHERE id = :Id")
    public UserEntity findUserById(int Id);

    @Query("SELECT * FROM user WHERE id = :id")
    public LiveData<UserEntity> loadUserById(int id);

    @Query("SELECT * FROM user where username = :username and password = :password")
    public LiveData<UserEntity> getUserByUsernameAndPassword(String username, String password);

    @Transaction
    @Query("SELECT * FROM user")
    public List<UserAndHistory> getUserHistory();
}
