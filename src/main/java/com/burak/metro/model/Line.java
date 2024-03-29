package com.burak.metro.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@MappedSuperclass
@RequiredArgsConstructor
@Getter
@Setter
abstract class Line extends IdentifiedModel {

    @Column(name = "beginning_time_period")
    private LocalTime beginningTimePeriod;
    @Column(name = "end_time_period")
    private LocalTime endTimePeriod;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "full_time_interval_id")
    protected FullTimeInterval fullTimeIntervalId;
    @Column(name = "working_days_interval")
    protected Double workingDaysInterval;
    @Column(name = "weekends_days_interval")
    protected Double weekendsDaysInterval;

    public Integer getFullTimeInterval() {
        return fullTimeIntervalId.getFullTimeInterval();
    }

}
