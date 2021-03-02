package com.tourguideassistant.bean;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CategoryWithTypes {

    @Embedded
    public CategoryBean categoryBeans;

    @Relation(parentColumn = "id", entityColumn = "id", entity = TypeBean.class)
    public List<TypeBean> typeBeans;
}
