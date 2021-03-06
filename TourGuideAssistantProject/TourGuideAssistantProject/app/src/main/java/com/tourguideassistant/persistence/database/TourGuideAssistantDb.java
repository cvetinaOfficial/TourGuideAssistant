package com.tourguideassistant.persistence.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.tourguideassistant.persistence.dao.CategoryDao;
import com.tourguideassistant.persistence.dao.FavouriteLandmarkDao;
import com.tourguideassistant.persistence.dao.LandmarkDao;
import com.tourguideassistant.persistence.dao.RegionDao;
import com.tourguideassistant.persistence.dao.TypeDao;
import com.tourguideassistant.persistence.dao.UpcomingTripDao;
import com.tourguideassistant.persistence.dao.UserDao;
import com.tourguideassistant.persistence.dao.UserHistoryDao;
import com.tourguideassistant.persistence.dao.UserPreferenceDao;
import com.tourguideassistant.persistence.entity.CategoryEntity;
import com.tourguideassistant.persistence.entity.FavouriteLandmarkEntity;
import com.tourguideassistant.persistence.entity.LandmarkEntity;
import com.tourguideassistant.persistence.entity.RegionEntity;
import com.tourguideassistant.persistence.entity.TypeEntity;
import com.tourguideassistant.persistence.entity.UpcomingTripEntity;
import com.tourguideassistant.persistence.entity.UpcomingTrip_LandmarkEntity;
import com.tourguideassistant.persistence.entity.UserEntity;
import com.tourguideassistant.persistence.entity.UserHistoryEntity;
import com.tourguideassistant.persistence.entity.UserPreferenceEntity;
import com.tourguideassistant.persistence.typeconverter.CategoryTypeConverter;
import com.tourguideassistant.persistence.typeconverter.DateTypeConverter;
import com.tourguideassistant.persistence.typeconverter.LandmarkTypeConverter;
import com.tourguideassistant.persistence.typeconverter.RegionTypeConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(version = 1, entities = {CategoryEntity.class, TypeEntity.class, UserPreferenceEntity.class,
        FavouriteLandmarkEntity.class, LandmarkEntity.class, RegionEntity.class,
        UpcomingTrip_LandmarkEntity.class,
        UpcomingTripEntity.class, UserHistoryEntity.class, UserEntity.class}, exportSchema = false)
@TypeConverters({CategoryTypeConverter.class, LandmarkTypeConverter.class,
        RegionTypeConverter.class, DateTypeConverter.class})
public abstract class TourGuideAssistantDb extends RoomDatabase {

    private static volatile TourGuideAssistantDb INSTANCE;
    private static final String DATABASE_NAME = "tour_guide_assistant";
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract UserDao userDao();
    public abstract TypeDao typeDao();
    public abstract CategoryDao categoryDao();
    public abstract UserPreferenceDao userPreferenceDao();
    public abstract FavouriteLandmarkDao favouriteLandmarkDao();
    public abstract LandmarkDao landmarkDao();
    public abstract RegionDao regionDao();
    public abstract UpcomingTripDao upcomingTripDao();
    public abstract UserHistoryDao userHistoryDao();

    public static TourGuideAssistantDb getInstance(Context context){
        if(INSTANCE == null){
            synchronized (TourGuideAssistantDb.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TourGuideAssistantDb.class,
                            DATABASE_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
