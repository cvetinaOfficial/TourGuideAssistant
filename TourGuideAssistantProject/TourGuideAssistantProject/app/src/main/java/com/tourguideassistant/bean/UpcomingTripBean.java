package com.tourguideassistant.bean;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "upcomingTrip")
public class UpcomingTripBean {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    public String startingPoint;

    public Date startDate;

    public Date endDate;

    @ForeignKey(entity = UserBean.class, parentColumns = "id", childColumns = "userId")
    public Integer userId;

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


}
