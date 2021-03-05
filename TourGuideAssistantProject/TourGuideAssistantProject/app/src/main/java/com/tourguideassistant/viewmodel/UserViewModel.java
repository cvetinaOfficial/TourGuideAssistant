package com.tourguideassistant.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tourguideassistant.persistence.entity.UserEntity;
import com.tourguideassistant.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    private final LiveData<List<UserEntity>> users;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        users = userRepository.getAllUsers();
    }

    LiveData<List<UserEntity>> getAllUsers() { return users; }

    public void insert(UserEntity userEntity) { userRepository.insert(userEntity); }

    public void update(UserEntity userEntity) { userRepository.update(userEntity); }

    public void delete(UserEntity userEntity) { userRepository.delete(userEntity); }

    public LiveData<UserEntity> getUserByUsernameAndPassword(String username, String password) {
        return userRepository.getUserEntityLiveData(username, password);
    }
}
