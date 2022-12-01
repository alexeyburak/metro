package com.burak.metro.service;

import com.burak.metro.exception.ApiRequestException;
import com.burak.metro.model.User;
import com.burak.metro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User not found");
        if (!user.isActive())
            throw new ApiRequestException("User was banned");

        return userRepository.findByUsername(username);
    }
}