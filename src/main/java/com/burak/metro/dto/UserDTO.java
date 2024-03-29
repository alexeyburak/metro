package com.burak.metro.dto;

import com.burak.metro.annotation.PasswordMatch;
import com.burak.metro.annotation.PasswordValid;
import com.burak.metro.annotation.UsernameValid;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Data
@NoArgsConstructor
@PasswordMatch
public class UserDTO {

    @UsernameValid
    private String username;
    @PasswordValid
    private String password;
    @PasswordValid
    private String confirmPassword;
}
