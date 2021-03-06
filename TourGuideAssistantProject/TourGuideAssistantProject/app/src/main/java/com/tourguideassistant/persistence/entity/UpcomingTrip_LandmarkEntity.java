package com.tourguideassistant.persistence.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"upcomingTripId", "landmarkId"})
public class UpcomingTrip_LandmarkEntity {

    @NonNull
    private Integer upcomingTripId;
    @NonNull
    private Integer landmarkId;

    public UpcomingTrip_LandmarkEntity(@NonNull Integer upcomingTripId, @NonNull Integer landmarkId) {
        this.upcomingTripId = upcomingTripId;
        this.landmarkId = landmarkId;
    }

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
