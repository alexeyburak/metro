package com.burak.metro.service.impl;

import com.burak.metro.exception.LineNotFoundException;
import com.burak.metro.model.BlueLine;
import com.burak.metro.model.GreenLine;
import com.burak.metro.model.RedLine;
import com.burak.metro.repository.BlueLineRepository;
import com.burak.metro.repository.GreenLineRepository;
import com.burak.metro.repository.RedLineRepository;
import com.burak.metro.service.LineService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LineServiceImpl implements LineService {

    RedLineRepository redLineRepository;
    BlueLineRepository blueLineRepository;
    GreenLineRepository greenLineRepository;

    @Override
    public RedLine getRedLineByLocalTime() {
        val time = LocalTime.now();
        log.info("Get Red line. Time: {}", time);

        return redLineRepository.findByTime(time)
                .orElseThrow(LineNotFoundException::new);
    }

    @Override
    public BlueLine getBlueLineByLocalTime() {
        val time = LocalTime.now();
        log.info("Get Blue line. Time: {}", time);

        return blueLineRepository.findByTime(time)
                .orElseThrow(LineNotFoundException::new);
    }

    @Override
    public GreenLine getGreenLineByLocalTime() {
        val time = LocalTime.now();
        log.info("Get Green line. Time: {}", time);

        return greenLineRepository.findByTime(time)
                .orElseThrow(LineNotFoundException::new);
    }

}
