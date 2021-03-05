package com.tourguideassistant.persistence.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UserAndHistory {
    @Embedded UserEntity userEntity;

    @Relation(
            parentColumn = "id",
            entityColumn = "userId"
    )
    public UserHistoryEntity userHistoryEntity;
}
