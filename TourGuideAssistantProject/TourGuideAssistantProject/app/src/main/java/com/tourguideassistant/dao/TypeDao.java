package com.tourguideassistant.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.bean.TypeBean;

import java.util.List;

@Dao
public interface TypeDao {

    @Insert
    void insertTypes(List<TypeBean> types);

    @Transaction
    @Query("SELECT * FROM type")
    List<TypeBean> getAllTypes();

    @Insert
    void insertType(TypeBean typeBean);

    @Delete
    void deleteType(TypeBean typeBean);

    @Update
    void updateType(TypeBean typeBean);

    @Transaction
    @Query("SELECT * FROM type WHERE categoryId = :Id")
    public List<TypeBean> findTypeById(int Id);

    @Transaction
    @Query("SELECT * FROM type WHERE categoryId = :id")
    public LiveData<TypeBean> loadTypeById(int id);

}