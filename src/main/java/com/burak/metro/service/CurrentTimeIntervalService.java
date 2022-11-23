package com.burak.metro.service;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public interface CurrentTimeIntervalService {
    Double getRedLineCurrentTimeInterval();
    Double getGreenLineCurrentTimeInterval();
    Double getBlueLineCurrentTimeInterval();
}
