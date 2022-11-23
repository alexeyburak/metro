package com.burak.metro.service;

import com.burak.metro.model.User;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public interface UserService {

    /**
     * <p>Save user to database after registration</p>
     * @param user the user to be added to the database
     * @return boolean operator which shows whether the save was made successfully
     * @since 1.0
     */
    boolean addUserToDatabase(User user);

}
