package com.burak.metro.controller.impl;

import com.burak.metro.controller.LineController;
import com.burak.metro.dto.LineIntervalResponse;
import com.burak.metro.service.TimeIntervalService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LineControllerImpl implements LineController {

    TimeIntervalService intervalService;

    @Override
    public ResponseEntity<LineIntervalResponse> redLineInfo() {
        return ok(
                intervalService.getRedLineTimeInterval()
        );
    }

    @Override
    public ResponseEntity<LineIntervalResponse> blueLineInfo() {
        return ok(
                intervalService.getBlueLineTimeInterval()
        );
    }

    @Override
    public ResponseEntity<LineIntervalResponse> greenLineInfo() {
        return ok(
                intervalService.getGreenLineTimeInterval()
        );
    }

}
