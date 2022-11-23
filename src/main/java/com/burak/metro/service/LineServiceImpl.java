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

    private int getNumberOfDayInWeek() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        return day.getValue();
    }

    @Override
    public Double getRedLineCurrentTimeInterval() {
        return switch (getNumberOfDayInWeek()) {
            // MONDAY, TUESDAY, WEDNESDAY, THURSDAY
            case 1, 2, 3, 4 -> this.getRedLineByCurrentTime()
                    .getWorkingDaysInterval();
            // FRIDAY
            case 5 -> this.getRedLineByCurrentTime()
                    .getFridayDaysInterval();
            // SATURDAY, SUNDAY
            case 6, 7 -> this.getRedLineByCurrentTime()
                    .getWeekendsDaysInterval();
            default -> null;
        };
    }

    @Override
    public Double getGreenLineCurrentTimeInterval() {
        return switch (getNumberOfDayInWeek()) {
            // MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
            case 1, 2, 3, 4, 5 -> this.getGreenLineByCurrentTime()
                    .getWorkingDaysInterval();
            // SATURDAY, SUNDAY
            case 6, 7 -> this.getGreenLineByCurrentTime()
                    .getWeekendsDaysInterval();
            default -> null;
        };
    }

    @Override
    public Double getBlueLineCurrentTimeInterval() {
        return switch (getNumberOfDayInWeek()) {
            // MONDAY, TUESDAY, WEDNESDAY, THURSDAY
            case 1, 2, 3, 4 -> this.getBlueLineByCurrentTime()
                    .getWorkingDaysInterval();
            // FRIDAY
            case 5 -> this.getRedLineByCurrentTime()
                    .getFridayDaysInterval();
            // SATURDAY, SUNDAY
            case 6, 7 -> this.getRedLineByCurrentTime()
                    .getWeekendsDaysInterval();
            default -> null;
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
