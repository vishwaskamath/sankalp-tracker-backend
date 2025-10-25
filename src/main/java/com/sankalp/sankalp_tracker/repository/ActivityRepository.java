package com.sankalp.sankalp_tracker.repository;

import com.sankalp.sankalp_tracker.model.Activity;
import com.sankalp.sankalp_tracker.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findByDate(LocalDate date);

    // Added: find activities for a specific user on a given date
    List<Activity> findByUserAndDate(Users user, LocalDate date);
}