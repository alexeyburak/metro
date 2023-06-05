package com.burak.metro.model;

import com.burak.metro.annotation.PasswordValid;
import com.burak.metro.annotation.UsernameValid;
import com.burak.metro.model.enums.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE)
public class User extends IdentifiedModel {

    @Column(name = "username")
    @UsernameValid
    String username;
    @Column(name = "password")
    @PasswordValid
    String password;
    @Column(name = "active")
    boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Enumerated(EnumType.STRING)
    Set<Role> roles = new HashSet<>();

}
