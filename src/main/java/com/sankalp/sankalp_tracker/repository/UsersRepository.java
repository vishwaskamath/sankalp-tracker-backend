package com.sankalp.sankalp_tracker.repository;

import com.sankalp.sankalp_tracker.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
}

