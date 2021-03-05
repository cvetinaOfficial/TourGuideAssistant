package com.tourguideassistant.persistence.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.tourguideassistant.persistence.enumtypes.Category;

import java.io.Serializable;

@Entity(tableName = "category")
public class CategoryEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private Category categoryType;

    public CategoryEntity() {};

    public CategoryEntity(@NonNull Category categoryType) {
        this.categoryType = categoryType;
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Category categoryType) {
        this.categoryType = categoryType;
    }
}
