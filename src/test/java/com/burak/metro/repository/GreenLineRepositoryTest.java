package com.burak.metro.repository;

import com.burak.metro.model.GreenLine;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = PRIVATE)
public class GreenLineRepositoryTest {

    @Mock
    GreenLineRepository greenLineRepository;

    @Test
    void findByTime_ExistingLine_ShouldReturnOptionalLineFromRepository() {
        // given
        GreenLine greenLine = new GreenLine();
        when(greenLineRepository.findByTime(any())).thenReturn(Optional.of(greenLine));

        // when
        Optional<GreenLine> result = greenLineRepository.findByTime(any());

        // then
        assertTrue(result.isPresent());
        assertEquals(greenLine, result.get());
    }

    @Test
    void findByTime_NonExistingLine_ShouldReturnOptionalEmpty() {
        // given
        when(greenLineRepository.findByTime(any())).thenReturn(Optional.empty());

        // when
        Optional<GreenLine> result = greenLineRepository.findByTime(any());

        // then
        assertTrue(result.isEmpty());
    }

}
