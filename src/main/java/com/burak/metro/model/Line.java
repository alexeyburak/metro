package com.burak.metro.model;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@MappedSuperclass
@RequiredArgsConstructor
abstract class Line extends IdentifiedModel {

    @Column(name = "time")
    private LocalDateTime time;
    @Column(name = "working_days_interval")
    protected Double workingDaysInterval;
    @Column(name = "friday_days_interval")
    protected Double fridayDaysInterval;
    @Column(name = "sunday_days_interval")
    protected Double sundayDaysInterval;
    @Column(name = "saturday_days_interval")
    protected Double saturdayDaysInterval;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fullTimeInterval")
    protected FullTimeInterval fullTimeInterval;
}
