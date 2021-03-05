package com.tourguideassistant.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tourguideassistant.persistence.entity.UserPreferenceEntity;
import com.tourguideassistant.repository.UserPreferenceRepository;

import java.util.List;

public class UserPreferenceViewModel extends AndroidViewModel {

    private UserPreferenceRepository userPreferenceRepository;

    private final LiveData<List<UserPreferenceEntity>> userPreferences;

    public UserPreferenceViewModel(@NonNull Application application) {
        super(application);
        userPreferenceRepository = new UserPreferenceRepository(application);
        userPreferences = userPreferenceRepository.getAllUserPreferences();
    }

    LiveData<List<UserPreferenceEntity>> getAllUserPreferences() { return userPreferences; }

    public void insert(UserPreferenceEntity userPreferenceEntity) { userPreferenceRepository.insert(userPreferenceEntity); }
}
