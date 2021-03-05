package com.tourguideassistant.persistence.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.tourguideassistant.persistence.enumtypes.LandmarkType;

import java.io.Serializable;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "type")
public class TypeEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private LandmarkType type;

    @ForeignKey(entity = CategoryEntity.class, parentColumns = "id", childColumns = "categoryId", onDelete = CASCADE)
    private Integer categoryId;

    public TypeEntity() {};

    public TypeEntity(@NonNull LandmarkType type){
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LandmarkType getType() {
        return type;
    }

    public void setType(LandmarkType type) {
        this.type = type;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}
