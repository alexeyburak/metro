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
@Table(name = "red_line")
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE)
public class RedLine extends Line {

    @Column(name = "friday_days_interval")
    Double fridayDaysInterval;

}
