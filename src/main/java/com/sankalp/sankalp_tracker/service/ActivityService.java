package com.sankalp.sankalp_tracker.service;

import com.sankalp.sankalp_tracker.model.Activity;
import com.sankalp.sankalp_tracker.model.Users;
import com.sankalp.sankalp_tracker.repository.ActivityRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Activity> getAllActivities(Integer userId) {
        Users userRef = entityManager.getReference(Users.class, userId);
        return activityRepository.findByUserAndDate(userRef, LocalDate.now());
    }

    public Activity addActivity(String text, Integer userId) {
        Activity activity = new Activity();
        activity.setText(text);
        activity.setDone(false);
        activity.setDate(LocalDate.now());
        Users userRef = entityManager.getReference(Users.class, userId);
        activity.setUser(userRef);
        return activityRepository.save(activity);
    }

    public Activity toggleActivityDone(Integer activityId) {
        return activityRepository.findById(activityId)
                .map(activity -> {
                    activity.setDone(!activity.getDone());
                    return activityRepository.save(activity);
                })
                .orElseThrow(() -> new RuntimeException("Activity not found with id: " + activityId));
    }
}