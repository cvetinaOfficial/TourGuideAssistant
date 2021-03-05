package com.tourguideassistant.persistence.entity;

import androidx.room.Entity;

@Entity(primaryKeys = {"upcomingTripId", "landmarkId"})
public class UpcomingTrip_LandmarkEntity {

    private Integer upcomingTripId;
    private Integer landmarkId;

    public Integer getUpcomingTripId() {
        return upcomingTripId;
    }

    public void setUpcomingTripId(Integer upcomingTripId) {
        this.upcomingTripId = upcomingTripId;
    }

    public Integer getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(Integer landmarkId) {
        this.landmarkId = landmarkId;
    }


}
