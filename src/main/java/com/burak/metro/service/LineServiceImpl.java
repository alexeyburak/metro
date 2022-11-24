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

    private DayOfWeek getNameOfDayWeek() {
        return DayOfWeek.valueOf(LocalDate
                .now()
                .getDayOfWeek()
                .name());
    }

    @Override
    public Double getRedLineCurrentTimeInterval() {
        return switch (getNameOfDayWeek()) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> this.getRedLineByCurrentTime()
                    .getWorkingDaysInterval();
            case FRIDAY -> this.getRedLineByCurrentTime()
                    .getFridayDaysInterval();
            case SATURDAY, SUNDAY -> this.getRedLineByCurrentTime()
                    .getWeekendsDaysInterval();
        };
    }

    @Override
    public Double getGreenLineCurrentTimeInterval() {
        return switch (getNameOfDayWeek()) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> this.getGreenLineByCurrentTime()
                    .getWorkingDaysInterval();
            case SATURDAY, SUNDAY -> this.getGreenLineByCurrentTime()
                    .getWeekendsDaysInterval();
        };
    }

    @Override
    public Double getBlueLineCurrentTimeInterval() {
        return switch (getNameOfDayWeek()) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> this.getBlueLineByCurrentTime()
                    .getWorkingDaysInterval();
            case FRIDAY -> this.getRedLineByCurrentTime()
                    .getFridayDaysInterval();
            case SATURDAY, SUNDAY -> this.getRedLineByCurrentTime()
                    .getWeekendsDaysInterval();
        };
    }

    @Override
    public RedLine getRedLineByCurrentTime() {
        log.info("Get RED LINE time");
        return redLineRepository
                .findLineByCurrentTime(LocalTime
                        .now());
    }

    @Override
    public GreenLine getGreenLineByCurrentTime() {
        log.info("Get GREEN LINE time");
        return greenLineRepository
                .findLineByCurrentTime(LocalTime
                        .now());
    }

    @Override
    public BlueLine getBlueLineByCurrentTime() {
        log.info("Get BLUE LINE time");
        return blueLineRepository
                .findLineByCurrentTime(LocalTime
                        .now());
    }

}
