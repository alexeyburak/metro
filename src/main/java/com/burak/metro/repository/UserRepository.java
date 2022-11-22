package com.burak.metro.repository;

import com.burak.metro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
