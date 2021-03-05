package com.tourguideassistant.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.persistence.entity.TypeEntity;

import java.util.List;

@Dao
public interface TypeDao {

    @Insert
    void insertTypes(List<TypeEntity> types);

    @Transaction
    @Query("SELECT * FROM type")
    List<TypeEntity> getAllTypes();

    @Insert
    void insertType(TypeEntity typeEntity);

    @Delete
    void deleteType(TypeEntity typeEntity);

    @Update
    void updateType(TypeEntity typeEntity);

    @Transaction
    @Query("SELECT * FROM type WHERE categoryId = :Id")
    public List<TypeEntity> findTypeById(int Id);

    @Transaction
    @Query("SELECT * FROM type WHERE categoryId = :id")
    public LiveData<TypeEntity> loadTypeById(int id);

}