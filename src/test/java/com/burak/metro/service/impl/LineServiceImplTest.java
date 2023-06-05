package com.burak.metro.service.impl;

import com.burak.metro.exception.LineNotFoundException;
import com.burak.metro.model.BlueLine;
import com.burak.metro.model.GreenLine;
import com.burak.metro.model.RedLine;
import com.burak.metro.repository.BlueLineRepository;
import com.burak.metro.repository.GreenLineRepository;
import com.burak.metro.repository.RedLineRepository;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = PRIVATE)
public class LineServiceImplTest {

    @Mock
    RedLineRepository redLineRepository;
    @Mock
    BlueLineRepository blueLineRepository;
    @Mock
    GreenLineRepository greenLineRepository;
    @InjectMocks
    LineServiceImpl lineService;

    @Test
    void getRedLineByLocalTime_ExistingLine_ShouldReturnLineFromRepository() {
        // given
        when(redLineRepository.findByTime(any()))
                .thenReturn(Optional.of(new RedLine()));

        //when
        lineService.getRedLineByLocalTime();

        //then
        verify(redLineRepository, times(1)).findByTime(any());
    }

    @Test
    void getRedLineByLocalTime_NonExistingLine_ShouldThrowLineNotFoundException() {
        // given
        when(redLineRepository.findByTime(any()))
                .thenReturn(Optional.empty());

        //when
        Executable executable = () -> lineService.getRedLineByLocalTime();

        //then
        assertThrows(LineNotFoundException.class, executable);
    }

    @Test
    void getBlueLineByLocalTime_ExistingLine_ShouldReturnLineFromRepository() {
        // given
        when(blueLineRepository.findByTime(any()))
                .thenReturn(Optional.of(new BlueLine()));

        //when
        lineService.getBlueLineByLocalTime();

        //then
        verify(blueLineRepository, times(1)).findByTime(any());
    }

    @Test
    void getBlueLineByLocalTime_NonExistingLine_ShouldThrowLineNotFoundException() {
        // given
        when(blueLineRepository.findByTime(any()))
                .thenReturn(Optional.empty());

        //when
        Executable executable = () -> lineService.getBlueLineByLocalTime();

        //then
        assertThrows(LineNotFoundException.class, executable);
    }

    @Test
    void getGreenLineByLocalTime_ExistingLine_ShouldReturnLineFromRepository() {
        // given
        when(greenLineRepository.findByTime(any()))
                .thenReturn(Optional.of(new GreenLine()));

        //when
        lineService.getGreenLineByLocalTime();

        //then
        verify(greenLineRepository, times(1)).findByTime(any());
    }

    @Test
    void getGreenLineByLocalTime_NonExistingLine_ShouldThrowLineNotFoundException() {
        // given
        when(greenLineRepository.findByTime(any()))
                .thenReturn(Optional.empty());

        //when
        Executable executable = () -> lineService.getGreenLineByLocalTime();

        //then
        assertThrows(LineNotFoundException.class, executable);
    }

}
