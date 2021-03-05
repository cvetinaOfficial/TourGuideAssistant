package com.tourguideassistant.persistence.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.tourguideassistant.persistence.entity.CategoryEntity;
import com.tourguideassistant.persistence.entity.CategoryWithTypes;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insertCategory(CategoryEntity categoryEntity);

    @Delete
    void deleteCategory(CategoryEntity categoryEntity);

    @Update
    void updateCategory(CategoryEntity categoryEntity);

    @Query("SELECT * FROM category")
    List<CategoryEntity> getAllCategories();

    @Query("SELECT * FROM category WHERE Id = :Id")
    public CategoryEntity findCategoryById(int Id);

    @Query("SELECT * FROM category WHERE id = :id")
    public LiveData<CategoryEntity> loadCategoryById(int id);

    @Transaction
    @Query("SELECT * FROM category")
    public List<CategoryWithTypes> getCategoryWithTypes();
}
