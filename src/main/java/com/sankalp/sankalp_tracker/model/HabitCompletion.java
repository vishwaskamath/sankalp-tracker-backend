package com.sankalp.sankalp_tracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "Habit_Completions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitCompletion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "completion_id")
    private Integer completionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "habit_id", nullable = false)
    private Habit habit;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user; // Optional: Remove if not in schema
}