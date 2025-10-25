package com.sankalp.sankalp_tracker.repository;

import com.sankalp.sankalp_tracker.model.HabitCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HabitCompletionRepository extends JpaRepository<HabitCompletion, Integer> {
    List<HabitCompletion> findByHabit_HabitIdAndDate(Integer habitId, LocalDate date);
}