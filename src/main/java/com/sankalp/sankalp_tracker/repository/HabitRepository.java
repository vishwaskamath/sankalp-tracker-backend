package com.sankalp.sankalp_tracker.repository;

import com.sankalp.sankalp_tracker.model.Habit;
import com.sankalp.sankalp_tracker.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Integer> {
    List<Habit> findByUser(Users user);
}