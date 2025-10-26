package com.sankalp.sankalp_tracker.service;

import com.sankalp.sankalp_tracker.model.Users;
import com.sankalp.sankalp_tracker.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Users registerUser(String username, String email, String rawPassword) {
        if (usersRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("User already exists with email: " + email);
        }
        Users user = new Users();
        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(rawPassword));
        return usersRepository.save(user);
    }

    public Users authenticateUser(String email, String rawPassword) {
        Optional<Users> maybeUser = usersRepository.findByEmail(email);
        if (maybeUser.isEmpty()) {
            throw new RuntimeException("Invalid email or password");
        }
        Users user = maybeUser.get();
        if (!passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
            throw new RuntimeException("Invalid email or password");
        }
        return user;
    }
}
