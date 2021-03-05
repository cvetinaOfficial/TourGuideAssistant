package com.tourguideassistant.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tourguideassistant.persistence.dao.UserPreferenceDao;
import com.tourguideassistant.persistence.database.TourGuideAssistantDb;
import com.tourguideassistant.persistence.entity.UserPreferenceEntity;

import java.util.List;

public class UserPreferenceRepository {

    private final UserPreferenceDao userPreferenceDao;
    private final LiveData<List<UserPreferenceEntity>> userPreferences;

    public UserPreferenceRepository(Application application) {
        TourGuideAssistantDb db = TourGuideAssistantDb.getInstance(application);
        userPreferenceDao = db.userPreferenceDao();
        userPreferences = userPreferenceDao.getAllUserPreferences();
    }

    //Room automatically executes live data on a background thread and takes care
    // database operations should not run ot the main thread
    public LiveData<List<UserPreferenceEntity>> getAllUserPreferences() {
        return userPreferences;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(UserPreferenceEntity userPreferenceEntity) {
        TourGuideAssistantDb.databaseWriteExecutor.execute(() -> {
            userPreferenceDao.insertUserPreference(userPreferenceEntity);
        });
    }

    public void update(UserPreferenceEntity userPreferenceEntity) {
        TourGuideAssistantDb.databaseWriteExecutor.execute(() -> {
            userPreferenceDao.updateUserPreference(userPreferenceEntity);
        });
    }

    public void delete(UserPreferenceEntity userPreferenceEntity) {
        TourGuideAssistantDb.databaseWriteExecutor.execute(() -> {
            userPreferenceDao.deleteUserPreference(userPreferenceEntity);
        });
    }
}
