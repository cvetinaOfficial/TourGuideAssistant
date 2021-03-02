package com.tourguideassistant.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.tourguideassistant.bean.CategoryBean;
import com.tourguideassistant.bean.FavouriteLandmarkBean;
import com.tourguideassistant.bean.LandmarkBean;
import com.tourguideassistant.bean.RegionBean;
import com.tourguideassistant.bean.TypeBean;
import com.tourguideassistant.bean.UpcomingTripBean;
import com.tourguideassistant.bean.UserBean;
import com.tourguideassistant.bean.UserHistoryBean;
import com.tourguideassistant.bean.UserPreferenceBean;
import com.tourguideassistant.dao.CategoryDao;
import com.tourguideassistant.dao.TypeDao;
import com.tourguideassistant.dao.UserDao;
import com.tourguideassistant.dao.UserPreferenceDao;
import com.tourguideassistant.typeconverter.CategoryTypeConverter;
import com.tourguideassistant.typeconverter.DateTypeConverter;
import com.tourguideassistant.typeconverter.LandmarkTypeConverter;
import com.tourguideassistant.typeconverter.RegionTypeConverter;

@Database(version = 1, entities = {CategoryBean.class, TypeBean.class, UserPreferenceBean.class,
        FavouriteLandmarkBean.class, LandmarkBean.class, RegionBean.class,
        UpcomingTripBean.class, UserHistoryBean.class, UserBean.class}, exportSchema = false)
@TypeConverters({CategoryTypeConverter.class, LandmarkTypeConverter.class,
        RegionTypeConverter.class, DateTypeConverter.class})
public abstract class TourGuideAssistantDb extends RoomDatabase {

    private static TourGuideAssistantDb tourGuideAssistantDb;

    public abstract UserDao userDao();
    public abstract TypeDao typeDao();
    public abstract CategoryDao categoryDao();
    public abstract UserPreferenceDao userPreferenceDao();

    private static String DATABASE_NAME = "tour_guide_assistant";

    private synchronized static TourGuideAssistantDb getInstance(Context context){
        if(tourGuideAssistantDb == null){
            tourGuideAssistantDb = Room.databaseBuilder(context,
                    TourGuideAssistantDb.class,
                    DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return tourGuideAssistantDb;
    }
}
