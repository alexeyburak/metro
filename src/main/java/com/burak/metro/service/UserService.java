package com.burak.metro.service;

import com.burak.metro.model.User;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public interface UserService {

    // Save user to database after registration
    boolean addUserToDatabase(User user);

}
