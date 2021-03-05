package com.tourguideassistant.persistence.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "user_preference")
public class UserPreferenceEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ForeignKey(entity = UserEntity.class, parentColumns = "id", childColumns = "id", onDelete = CASCADE)
    private Integer userId;

    @ForeignKey(entity = CategoryEntity.class, parentColumns = "id", childColumns = "id")
    private Integer categoryId;

    @ForeignKey(entity = TypeEntity.class, parentColumns = "id", childColumns = "id", onDelete = CASCADE)
    private Integer typeId;

    public UserPreferenceEntity() {};

    public UserPreferenceEntity(@NonNull Integer userId, @NonNull Integer categoryId, @NonNull Integer typeId){
        this.userId = userId;
        this.categoryId = categoryId;
        this.typeId= typeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
