package com.tourguideassistant.persistence.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CategoryWithTypes {
// one-to-many relationship
    @Embedded
    public CategoryEntity categoryEntity;

    @Relation(parentColumn = "id", entityColumn = "categoryId", entity = TypeEntity.class)
    public List<TypeEntity> typeEntities;
}
