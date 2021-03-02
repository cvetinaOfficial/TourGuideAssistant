package com.tourguideassistant.bean;

import androidx.room.Entity;

@Entity(primaryKeys = {"upcomingTripId", "landmarkId"})
public class UpcomingTrip_LandmarkBean {

    public Integer upcomingTripId;

    public Integer landmarkId;
}
