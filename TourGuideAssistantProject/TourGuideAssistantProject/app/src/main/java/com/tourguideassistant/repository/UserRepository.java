package com.tourguideassistant.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.tourguideassistant.persistence.dao.UserDao;
import com.tourguideassistant.persistence.database.TourGuideAssistantDb;
import com.tourguideassistant.persistence.entity.UserEntity;

import java.util.List;

public class UserRepository {

    private final UserDao userDao;
    private final LiveData<List<UserEntity>> users;

    public UserRepository(Application application) {
        TourGuideAssistantDb db = TourGuideAssistantDb.getInstance(application);
        userDao = db.userDao();
        users = userDao.getAllUsers();
    }

    //Room automatically executes live data on a background thread and takes care
    // database operations should not run ot the main thread
    public LiveData<List<UserEntity>> getAllUsers() {
        return users;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void registerUser(UserEntity userEntity) {
        TourGuideAssistantDb.databaseWriteExecutor.execute(() -> {
            userDao.registerUser(userEntity);
        });
    }

    public void update(UserEntity userEntity) {
        TourGuideAssistantDb.databaseWriteExecutor.execute(() -> {
            userDao.updateUser(userEntity);
        });
    }

    public void delete(UserEntity userEntity) {
        TourGuideAssistantDb.databaseWriteExecutor.execute(() -> {
            userDao.deleteUser(userEntity);
        });
    }

    public LiveData<UserEntity> findUserByUsername(String username){
        LiveData<UserEntity> user = userDao.findUserByUsername(username);

        return user;
    }

    public UserEntity getUserEntityLiveData(String username, String password){
        final UserEntity[] userEntity = new UserEntity[1];
        TourGuideAssistantDb.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userEntity[0] = userDao.getUserByUsernameAndPassword(username, password);
            }
        });

        return userEntity[0];
    }
}
