package com.burak.metro.model.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
