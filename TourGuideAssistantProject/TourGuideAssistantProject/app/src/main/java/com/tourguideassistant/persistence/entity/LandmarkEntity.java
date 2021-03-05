package com.tourguideassistant.persistence.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "landmark")
public class LandmarkEntity {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String name;

    private String imagePath;

    private String description;

    @ForeignKey(entity = RegionEntity.class, parentColumns = "id", childColumns = "regionId")
    private Integer regionId;

    @ForeignKey(entity = CategoryEntity.class, parentColumns = "id", childColumns = "categoryId")
    private Integer categoryId;

    @ForeignKey(entity = TypeEntity.class, parentColumns = "id", childColumns = "typeId")
    private Integer typeId;

    public LandmarkEntity() {};

    public LandmarkEntity(@NonNull String name,
                          @NonNull String imagePath,
                          @NonNull Integer regionId,
                          @NonNull Integer categoryId,
                          @NonNull Integer typeId,
                          String description) {
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.categoryId = categoryId;
        this.typeId = typeId;
        this.regionId = regionId;
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }


}
