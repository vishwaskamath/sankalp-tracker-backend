package com.sankalp.sankalp_tracker.mutation;

import com.sankalp.sankalp_tracker.model.Activity;
import com.sankalp.sankalp_tracker.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin // optional
public class ActivityMutationResolver {

    @Autowired
    private ActivityService activityService;

    @MutationMapping
    public Activity addActivity(@Argument String text, @Argument Integer userId) {
        return activityService.addActivity(text, userId);
    }

    @MutationMapping
    public Activity toggleActivityDone(@Argument Integer activityId) {
        return activityService.toggleActivityDone(activityId);
    }
}
