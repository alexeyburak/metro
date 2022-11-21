package com.burak.metro.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Data
@NoArgsConstructor
public class UserDTO {

    private String username;
    private String password;
    private String confirmPassword;
}
