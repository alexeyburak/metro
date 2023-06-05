package com.burak.metro.service.impl;

import com.burak.metro.dto.LineIntervalResponse;
import com.burak.metro.model.Line;
import com.burak.metro.service.LineService;
import com.burak.metro.service.TimeIntervalService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TimeIntervalServiceImpl implements TimeIntervalService {

    static String RED_LINE = "Aŭtazavadskaja line";
    static String BLUE_LINE = "Maskoŭskaja line";
    static String GREEN_LINE = "Zielienalužskaja line";
    LineService lineService;

    @Override
    public LineIntervalResponse getRedLineTimeInterval() {
        val line = lineService.getRedLineByLocalTime();
        LineIntervalResponse response = buildResponse(RED_LINE, line);

        switch (getNameOfDayWeek()) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> response.setTime(line.getWorkingDaysInterval());
            case FRIDAY -> response.setTime(line.getFridayDaysInterval());
            case SATURDAY, SUNDAY -> response.setTime(line.getWeekendsDaysInterval());
        }

        return response;
    }

    @Override
    public LineIntervalResponse getBlueLineTimeInterval() {
        val line = lineService.getBlueLineByLocalTime();
        LineIntervalResponse response = buildResponse(BLUE_LINE, line);

        switch (getNameOfDayWeek()) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> response.setTime(line.getWorkingDaysInterval());
            case FRIDAY -> response.setTime(line.getFridayDaysInterval());
            case SATURDAY, SUNDAY -> response.setTime(line.getWeekendsDaysInterval());
        }

        return response;
    }

    @Override
    public LineIntervalResponse getGreenLineTimeInterval() {
        val line = lineService.getGreenLineByLocalTime();
        LineIntervalResponse response = buildResponse(GREEN_LINE, line);

        switch (getNameOfDayWeek()) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> response.setTime(line.getWorkingDaysInterval());
            case SATURDAY, SUNDAY -> response.setTime(line.getWeekendsDaysInterval());
        }

        return response;
    }

    private <V extends Line> LineIntervalResponse buildResponse(String name, V line) {
        return LineIntervalResponse.builder()
                .name(name)
                .allTime(line.getFullTimeInterval())
                .build();
    }

    private DayOfWeek getNameOfDayWeek() {
        return DayOfWeek.valueOf(LocalDate
                .now()
                .getDayOfWeek()
                .name());
    }

}
