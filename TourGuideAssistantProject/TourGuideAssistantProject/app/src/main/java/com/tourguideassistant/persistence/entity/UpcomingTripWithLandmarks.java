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
            associateBy = @Junction(value = UpcomingTrip_LandmarkEntity.class,
                    parentColumn = "upcomingTripId",
                    entityColumn = "landmarkId")
    )
    public List<LandmarkEntity> landmarkEntities;
}
