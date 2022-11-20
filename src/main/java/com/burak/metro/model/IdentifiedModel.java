package com.burak.metro.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@MappedSuperclass
@Data
@RequiredArgsConstructor
public class IdentifiedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

}