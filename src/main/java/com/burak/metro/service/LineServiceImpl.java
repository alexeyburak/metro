package com.burak.metro.service;

import com.burak.metro.model.BlueLine;
import com.burak.metro.model.GreenLine;
import com.burak.metro.model.RedLine;
import com.burak.metro.repository.BlueLineRepository;
import com.burak.metro.repository.GreenLineRepository;
import com.burak.metro.repository.RedLineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class LineServiceImpl implements LineService, CurrentTimeIntervalService {

    private final BlueLineRepository blueLineRepository;
    private final GreenLineRepository greenLineRepository;
    private final RedLineRepository redLineRepository;

    private int getDayNumberNew() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        return day.getValue();
    }

    @Override
    public Double getRedLineCurrentTimeInterval() {
        switch (getDayNumberNew()) {
            case 1, 2, 3, 4:
                return redLineRepository
                        .findTimeIntervalByDayOfWeek(LocalTime.now(),
                                "working_days_interval")
                        .getWorkingDaysInterval();
            case 5:
                return redLineRepository
                        .findTimeIntervalByDayOfWeek(LocalTime.now(),
                                "friday_days_interval")
                        .getFridayDaysInterval();
            case 6, 7:
                return redLineRepository
                        .findTimeIntervalByDayOfWeek(LocalTime.now(),
                                "weekends_days_interval")
                        .getWeekendsDaysInterval();
        }
        log.info("Get red line time");
        return null;
    }

    @Override
    public Double getGreenLineCurrentTimeInterval() {
        switch (getDayNumberNew()) {
            case 1, 2, 3, 4, 5:
                return greenLineRepository
                        .findTimeIntervalByDayOfWeek(LocalTime.now(),
                                "working_days_interval")
                        .getWorkingDaysInterval();
            case 6, 7:
                return greenLineRepository
                        .findTimeIntervalByDayOfWeek(LocalTime.now(),
                                "weekends_days_interval")
                        .getWeekendsDaysInterval();
        }
        log.info("Get green line time");
        return null;
    }

    @Override
    public Double getBlueLineCurrentTimeInterval() {
        switch (getDayNumberNew()) {
            case 1, 2, 3, 4:
                return blueLineRepository
                        .findTimeIntervalByDayOfWeek(LocalTime.now(),
                                "working_days_interval")
                        .getWorkingDaysInterval();
            case 5:
                return blueLineRepository
                        .findTimeIntervalByDayOfWeek(LocalTime.now(),
                                "friday_days_interval")
                        .getFridayDaysInterval();
            case 6, 7:
                return blueLineRepository
                        .findTimeIntervalByDayOfWeek(LocalTime.now(),
                                "weekends_days_interval")
                        .getWeekendsDaysInterval();
        }
        log.info("Get blue line time");
        return null;
    }

    @Override
    public RedLine getRedLineByCurrentTime() {
        return redLineRepository
                .findLineByCurrentTime(LocalTime
                        .now());
    }

    @Override
    public GreenLine getGreenLineByCurrentTime() {
        return greenLineRepository
                .findLineByCurrentTime(LocalTime
                        .now());
    }

    @Override
    public BlueLine getBlueLineByCurrentTime() {
        return blueLineRepository
                .findLineByCurrentTime(LocalTime
                        .now());
    }

}
