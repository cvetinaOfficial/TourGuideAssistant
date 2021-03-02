package com.tourguideassistant.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.bean.CategoryBean;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insertCategory(CategoryBean categoryBean);

    @Delete
    void deleteCategory(CategoryBean categoryBean);

    @Update
    void updateCategory(CategoryBean categoryBean);

    @Transaction
    @Query("SELECT * FROM category")
    List<CategoryBean> getAllCategories();

    @Transaction
    @Query("SELECT * FROM category WHERE Id = :Id")
    public List<CategoryBean> findCategoryById(int Id);

    @Transaction
    @Query("SELECT * FROM category WHERE id = :id")
    public LiveData<CategoryBean> loadCategoryById(int id);
}
