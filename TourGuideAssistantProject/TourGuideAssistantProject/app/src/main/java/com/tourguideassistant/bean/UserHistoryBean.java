package com.tourguideassistant.bean;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class UserHistoryBean {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ForeignKey(entity = UserBean.class, childColumns = "userId", parentColumns = "id")
    public Integer userId;

    @ForeignKey(entity = LandmarkBean.class, parentColumns = "id", childColumns = "landmarkId")
    public Integer landmarkId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
