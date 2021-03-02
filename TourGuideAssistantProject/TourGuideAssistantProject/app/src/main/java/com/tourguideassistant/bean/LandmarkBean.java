package com.tourguideassistant.bean;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "landmark")
public class LandmarkBean {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    public String name;

    public String imagePath;

    public String description;

    @ForeignKey(entity = RegionBean.class, parentColumns = "id", childColumns = "regionId")
    public Integer regionId;

    @ForeignKey(entity = CategoryBean.class, parentColumns = "id", childColumns = "categoryId")
    public Integer categoryId;

    @ForeignKey(entity = TypeBean.class, parentColumns = "id", childColumns = "typeId")
    public Integer typeId;

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


}
