package com.tourguideassistant.bean;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.io.Serializable;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "user_preference")
public class UserPreferenceBean implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ForeignKey(entity = UserBean.class, parentColumns = "id", childColumns = "id", onDelete = CASCADE)
    public Integer userId;

    @ForeignKey(entity = CategoryBean.class, parentColumns = "id", childColumns = "id")
    public Integer categoryId;

    @ForeignKey(entity = TypeBean.class, parentColumns = "id", childColumns = "id", onDelete = CASCADE)
    public Integer typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
