package com.tourguideassistant.bean;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "favouriteLandmark")
public class FavouriteLandmarkBean {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ForeignKey(entity = LandmarkBean.class, parentColumns = "id", childColumns = "landmarkId")
    public Integer landmarkId;

    @ForeignKey(entity = UserBean.class, parentColumns = "id", childColumns = "userId")
    public Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
