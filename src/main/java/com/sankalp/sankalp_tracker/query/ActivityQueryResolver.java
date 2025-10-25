package com.sankalp.sankalp_tracker.query;

import com.sankalp.sankalp_tracker.model.Activity;
import com.sankalp.sankalp_tracker.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin // optional if accessed from frontend
public class ActivityQueryResolver {

    @Autowired
    private ActivityService activityService;

    @QueryMapping
    public List<Activity> getTodaysActivities(@Argument Integer userId) {
        // Service now filters by today’s date and userId internally
        return activityService.getAllActivities(userId);
    }
}
