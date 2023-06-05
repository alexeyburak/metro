package com.burak.metro.service;

import com.burak.metro.dto.LineIntervalResponse;

public interface TimeIntervalService {
    /**
     * <p>Required time interval at certain hours and days of the week</p>
     * @return double parameter equal to the time interval at certain hours and days of the week
     * @since 1.0
     */
    LineIntervalResponse getRedLineTimeInterval();
    /**
     * <p>Required time interval at certain hours and days of the week</p>
     * @return double parameter equal to the time interval at certain hours and days of the week
     * @since 1.0
     */
    LineIntervalResponse getGreenLineTimeInterval();
    /**
     * <p>Required time interval at certain hours and days of the week</p>
     * @return double parameter equal to the time interval at certain hours and days of the week
     * @since 1.0
     */
    LineIntervalResponse getBlueLineTimeInterval();
}
