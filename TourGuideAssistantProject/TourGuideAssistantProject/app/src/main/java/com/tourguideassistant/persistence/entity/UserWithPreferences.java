package com.tourguideassistant.persistence.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWithPreferences {
    @Embedded
    public UserEntity userEntity;

    @Relation(parentColumn = "id", entityColumn = "userId")
    public List<UserPreferenceEntity> userPreferenceEntities;
}
