package com.sankalp.sankalp_tracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "Activities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Integer activityId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now();

    @Column(name = "text", nullable = false, length = 255)
    private String text;

    @Column(name = "done")
    private Boolean done = false;
}