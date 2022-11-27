package com.burak.metro.service;

import com.burak.metro.model.User;
import com.burak.metro.model.enums.Role;
import com.burak.metro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean addUserToDatabase(User user) {
        String username = user.getUsername();
        if (userRepository.findByUsername(username) != null)
            return false;

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.USER);

        userRepository.save(user);
        log.info("Saving User. Username: {}", username);
        return true;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByUsername(principal.getName());
    }

    @Override
    public void updateUserById(Long id, User userDb) {
        User user = this.getUserById(id);
        if (user == null)
            throw new IllegalStateException("User not found");

        user.setUsername(userDb.getUsername());
        user.setPassword(passwordEncoder.encode(userDb.getPassword()));

        userRepository.save(user);
        log.info("Update user. User username: {}", user.getUsername());
    }
}
