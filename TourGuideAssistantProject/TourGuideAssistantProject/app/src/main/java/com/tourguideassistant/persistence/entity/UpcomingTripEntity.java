package com.tourguideassistant.persistence.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "upcomingTrip")
public class UpcomingTripEntity {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String startingPoint;

    private Date startDate;

    private Date endDate;

    @ForeignKey(entity = UserEntity.class, parentColumns = "id", childColumns = "userId")
    private Integer userId;

    public UpcomingTripEntity() {};

    public UpcomingTripEntity(@NonNull String startingPoint, @NonNull Date startDate, @NonNull Date endDate){
        this.startingPoint = startingPoint;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
