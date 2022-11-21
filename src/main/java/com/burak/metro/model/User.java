package com.burak.metro.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
public class User extends IdentifiedModel {

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

}
