package com.burak.metro.model;

import com.burak.metro.annotation.PasswordValid;
import com.burak.metro.annotation.UsernameValid;
import com.burak.metro.model.enums.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static com.burak.metro.model.enums.Role.ADMIN;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User extends IdentifiedModel implements UserDetails {

    @Column(name = "username")
    @UsernameValid
    private String username;
    @Column(name = "password")
    @PasswordValid
    private String password;
    @Column(name = "active")
    private boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    public boolean isAdmin() {
        return roles.contains(ADMIN);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
