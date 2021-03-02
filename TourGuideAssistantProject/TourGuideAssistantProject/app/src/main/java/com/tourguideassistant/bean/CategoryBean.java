package com.tourguideassistant.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.tourguideassistant.enumtypes.Category;

import java.io.Serializable;

@Entity(tableName = "category")
public class CategoryBean implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public Integer id;

    public Category categoryType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategoryType() {
        return categoryType;
    }
}
