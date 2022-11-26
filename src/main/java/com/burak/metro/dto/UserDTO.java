package com.burak.metro.dto;

import com.burak.metro.annotation.PasswordMatch;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Data
@NoArgsConstructor
@PasswordMatch
public class UserDTO {

    @Size(min = 3, max = 15, message = "Name must be between 3 and 15 characters")
    @NotBlank(message = "Name is required")
    private String username;
    @NotBlank(message = "Password is required")
    private String password;
    @NotBlank(message = "Password confirm is required")
    private String confirmPassword;
}
