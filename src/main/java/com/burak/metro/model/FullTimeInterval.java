package com.burak.metro.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "full_time_interval")
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE)
public class FullTimeInterval extends IdentifiedModel {

    @Column(name = "full_time_interval")
    Integer fullTimeInterval;
}
