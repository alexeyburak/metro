package com.burak.metro.service;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public interface CurrentTimeIntervalService {
    /**
     * <p>Required time interval at certain hours and days of the week</p>
     * @return double parameter equal to the time interval at certain hours and days of the week
     * @since 1.0
     */
    Double getRedLineCurrentTimeInterval();
    /**
     * <p>Required time interval at certain hours and days of the week</p>
     * @return double parameter equal to the time interval at certain hours and days of the week
     * @since 1.0
     */
    Double getGreenLineCurrentTimeInterval();
    /**
     * <p>Required time interval at certain hours and days of the week</p>
     * @return double parameter equal to the time interval at certain hours and days of the week
     * @since 1.0
     */
    Double getBlueLineCurrentTimeInterval();
}
