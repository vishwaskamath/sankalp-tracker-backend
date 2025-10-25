package com.sankalp.sankalp_tracker.service;

import com.sankalp.sankalp_tracker.model.Habit;
import com.sankalp.sankalp_tracker.model.HabitCompletion;
import com.sankalp.sankalp_tracker.model.Recurrence;
import com.sankalp.sankalp_tracker.model.Users;
import com.sankalp.sankalp_tracker.repository.HabitCompletionRepository;
import com.sankalp.sankalp_tracker.repository.HabitRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitService {
    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private HabitCompletionRepository habitCompletionRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Habit> getAllHabits(Integer userId) {
        Users userRef = entityManager.getReference(Users.class, userId);
        return habitRepository.findByUser(userRef);
    }

    public Habit addHabit(String text, Recurrence recurrence, int goal, Integer userId) {
        Habit habit = new Habit();
        habit.setText(text);
        habit.setRecurrence(recurrence);
        habit.setGoal(goal);
        habit.setCreatedDate(LocalDate.now());
        Users userRef = entityManager.getReference(Users.class, userId);
        habit.setUser(userRef);
        return habitRepository.save(habit);
    }

    public Habit toggleHabitDone(Integer habitId) {
        return habitRepository.findById(habitId)
                .map(habit -> {
                    HabitCompletion completion = new HabitCompletion();
                    completion.setHabit(habit);
                    completion.setDate(LocalDate.now());
                    Users userRef = entityManager.getReference(Users.class, habit.getUser().getUserId());
                    completion.setUser(userRef);
                    habitCompletionRepository.save(completion); // Save completion
                    return habit;
                })
                .orElseThrow(() -> new RuntimeException("Habit not found with id: " + habitId));
    }
}