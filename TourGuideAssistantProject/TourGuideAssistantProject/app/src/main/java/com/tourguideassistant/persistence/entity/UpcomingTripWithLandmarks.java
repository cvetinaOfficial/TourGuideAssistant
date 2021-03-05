package com.tourguideassistant.persistence.entity;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UpcomingTripWithLandmarks {
    @Embedded
    public UpcomingTripEntity upcomingTripEntity;
    @Relation(
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(UpcomingTrip_LandmarkEntity.class)
    )
    public List<LandmarkEntity> landmarkEntities;
}
