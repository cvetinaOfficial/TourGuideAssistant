package com.tourguideassistant.persistence.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserPreferenceWithCategoryAndType {

    @Embedded
    public UserPreferenceEntity userPreferenceEntity;

    @Relation(entity = CategoryEntity.class, parentColumn = "id", entityColumn = "userId")
    public List<CategoryWithTypes> categoryWithTypes;
}
