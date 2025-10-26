package com.sankalp.sankalp_tracker.mutation;

import com.sankalp.sankalp_tracker.model.Users;
import com.sankalp.sankalp_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class UserMutationResolver {

    @Autowired
    private UserService userService;

    @MutationMapping
    public Users registerUser(@Argument String username, @Argument String email, @Argument String password) {
        return userService.registerUser(username, email, password);
    }

    @MutationMapping
    public Users loginUser(@Argument String email, @Argument String password) {
        return userService.authenticateUser(email, password);
    }
}
