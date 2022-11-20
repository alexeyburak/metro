package com.burak.metro.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Entity
@Table(name = "full_time_interval")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class FullTimeInterval extends IdentifiedModel {

    @Column(name = "full_time_interval")
    private Integer fullTimeInterval;
}
