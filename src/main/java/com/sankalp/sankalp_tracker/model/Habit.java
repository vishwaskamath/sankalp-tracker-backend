package com.sankalp.sankalp_tracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Habits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habit_id")
    private Integer habitId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "text", nullable = false, length = 255)
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "recurrence", nullable = false)
    private Recurrence recurrence;

    @Column(name = "goal", nullable = false)
    private Integer goal;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate = LocalDate.now();

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HabitCompletion> completions = new ArrayList<>();
}