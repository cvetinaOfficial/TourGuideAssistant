package com.tourguideassistant.persistence.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "favouriteLandmark")
public class FavouriteLandmarkEntity {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ForeignKey(entity = LandmarkEntity.class, parentColumns = "id", childColumns = "landmarkId")
    private Integer landmarkId;

    @ForeignKey(entity = UserEntity.class, parentColumns = "id", childColumns = "userId")
    private Integer userId;

    public FavouriteLandmarkEntity() {};

    public FavouriteLandmarkEntity(@NonNull Integer landmarkId, @NonNull Integer userId) {
        this.landmarkId = landmarkId;
        this.userId = userId;
    };


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(Integer landmarkId) {
        this.landmarkId = landmarkId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
