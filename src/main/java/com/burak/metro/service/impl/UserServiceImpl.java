package com.burak.metro.service.impl;

import com.burak.metro.exception.ApiRequestException;
import com.burak.metro.model.User;
import com.burak.metro.model.enums.Role;
import com.burak.metro.repository.UserRepository;
import com.burak.metro.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public boolean addUserToDatabase(User user) {
        String username = user.getUsername();
        if (userRepository.findByUsername(username) != null)
            return false;

        user.setActive(true);
        user.setPassword(user.getPassword());
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
            throw new ApiRequestException("User not found");

        user.setUsername(userDb.getUsername());
        user.setPassword(userDb.getPassword());

        userRepository.save(user);
        log.info("Update user. User username: {}", user.getUsername());
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
        log.warn("Delete user account. User id: {}", id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
