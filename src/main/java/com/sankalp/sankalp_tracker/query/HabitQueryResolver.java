package com.sankalp.sankalp_tracker.query;

import com.sankalp.sankalp_tracker.model.Habit;
import com.sankalp.sankalp_tracker.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin // optional if used by frontend
public class HabitQueryResolver {

    @Autowired
    private HabitService habitService;

    @QueryMapping
    public List<Habit> getTodaysHabits(@Argument Integer userId) {
        // service filters internally by today's date and userId if implemented that way
        return habitService.getAllHabits(userId);
    }
}
