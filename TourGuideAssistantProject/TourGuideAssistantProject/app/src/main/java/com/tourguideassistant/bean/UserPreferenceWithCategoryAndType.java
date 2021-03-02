package com.tourguideassistant.bean;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserPreferenceWithCategoryAndType {

    @Embedded
    public UserBean userBean;

    @Relation(parentColumn = "id", entityColumn = "categoryId", entity = CategoryBean.class)
    public List<CategoryWithTypes> categoryWithTypes;

    public UserPreferenceWithCategoryAndType(UserBean userBean, List<CategoryWithTypes> categoryWithTypes) {
        this.userBean = userBean;
        this.categoryWithTypes = categoryWithTypes;
    }

    /*@Embedded
    public CategoryBean categoryBean;
    @Embedded
    public TypeBean typeBean;

    @Relation(parentColumn = "id", entityColumn = "id" , entity = UserPreferenceBean.class)
    public List<UserPreferenceBean> userPreferenceBeans;

    public UserPreferenceWithCategoryAndType(UserBean userBean, CategoryBean categoryBean, TypeBean typeBean, List<UserPreferenceBean> userPreferenceBeans) {
        this.userBean = userBean;
        this.categoryBean = categoryBean;
        this.typeBean = typeBean;
        this.userPreferenceBeans = userPreferenceBeans;
    }*/
}
