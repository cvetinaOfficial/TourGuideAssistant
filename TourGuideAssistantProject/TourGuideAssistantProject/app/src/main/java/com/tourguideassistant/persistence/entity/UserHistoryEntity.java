package com.tourguideassistant.persistence.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_history")
public class UserHistoryEntity {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ForeignKey(entity = UserEntity.class, childColumns = "userId", parentColumns = "id")
    private Integer userId;

    @ForeignKey(entity = LandmarkEntity.class, parentColumns = "id", childColumns = "landmarkId")
    private Integer landmarkId;

    public UserHistoryEntity() {};

    public UserHistoryEntity(@NonNull Integer userId, @NonNull Integer landmarkId){
        this.userId = userId;
        this.landmarkId = landmarkId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(Integer landmarkId) {
        this.landmarkId = landmarkId;
    }
}
