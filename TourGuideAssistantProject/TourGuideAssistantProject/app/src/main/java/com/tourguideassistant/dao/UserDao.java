package com.tourguideassistant.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.bean.UserBean;

import java.util.List;

@Dao
public interface UserDao {

    @Transaction
    @Query("SELECT * FROM user")
    List<UserBean> getAllUsers();

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insertUser(UserBean userBean);

    @Delete
    void deleteUser(UserBean userBean);

    @Update
    void updateUser(UserBean userBean);

    @Query("SELECT * FROM user WHERE id = :Id")
    public List<UserBean> findUserById(int Id);
}
