package com.tourguideassistant.persistence.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UserAndHistory {
    public @Embedded UserEntity userEntity;

    @Relation(
            parentColumn = "id",
            entityColumn = "userId"
    )
    public UserHistoryEntity userHistoryEntity;
}
