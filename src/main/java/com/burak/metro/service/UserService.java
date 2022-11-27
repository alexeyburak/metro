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
    /**
     * <p>Search user in database by id</p>
     * @param id user id which is being searched in the database
     * @return user from database or else null
     * @since 1.0
     */
    User getUserById(Long id);
    /**
     * <p>Update user by id</p>
     * @param id user id which will change its data
     * @param userDb new object with changed data
     * @since 1.0
     */
    void updateUserById(Long id, User userDb);

}
