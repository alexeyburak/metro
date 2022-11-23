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

import java.time.LocalTime;


/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class LineServiceImpl implements LineService{

    private final BlueLineRepository blueLineRepository;
    private final GreenLineRepository greenLineRepository;
    private final RedLineRepository redLineRepository;

    public RedLine getRedLineByCurrentTime() {
        return redLineRepository
                .findLineByCurrentTime(LocalTime
                        .now());
    }

    public GreenLine getGreenLineByCurrentTime() {
        return greenLineRepository
                .findLineByCurrentTime(LocalTime
                        .now());
    }

    public BlueLine getBlueLineByCurrentTime() {
        return blueLineRepository
                .findLineByCurrentTime(LocalTime
                        .now());
    }

}
