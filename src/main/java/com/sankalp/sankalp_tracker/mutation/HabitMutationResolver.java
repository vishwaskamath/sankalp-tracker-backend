package com.sankalp.sankalp_tracker.mutation;

import com.sankalp.sankalp_tracker.model.Habit;
import com.sankalp.sankalp_tracker.model.Recurrence;
import com.sankalp.sankalp_tracker.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin // optional if frontend calls this directly
public class HabitMutationResolver {

    @Autowired
    private HabitService habitService;

    @MutationMapping
    public Habit addHabit(@Argument String text, @Argument String recurrence, @Argument int goal, @Argument Integer userId) {
        return habitService.addHabit(text, Recurrence.valueOf(recurrence.toUpperCase()), goal, userId);
    }

    @MutationMapping
    public Habit toggleHabitDone(@Argument Integer habitId) {
        return habitService.toggleHabitDone(habitId);
    }
}
