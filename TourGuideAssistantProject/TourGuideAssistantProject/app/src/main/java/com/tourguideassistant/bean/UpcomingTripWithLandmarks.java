package com.tourguideassistant.bean;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UpcomingTripWithLandmarks {
    @Embedded
    public UpcomingTripBean upcomingTripBean;
    @Relation(
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(UpcomingTrip_LandmarkBean.class)
    )
    public List<LandmarkBean> landmarkBeans;
}
