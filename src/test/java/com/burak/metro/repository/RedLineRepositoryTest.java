package com.burak.metro.repository;

import com.burak.metro.model.RedLine;
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
public class RedLineRepositoryTest {

    @Mock
    RedLineRepository redLineRepository;

    @Test
    void findByTime_ExistingLine_ShouldReturnOptionalLineFromRepository() {
        // given
        RedLine redLine = new RedLine();
        when(redLineRepository.findByTime(any())).thenReturn(Optional.of(redLine));

        // when
        Optional<RedLine> result = redLineRepository.findByTime(any());

        // then
        assertTrue(result.isPresent());
        assertEquals(redLine, result.get());
    }

    @Test
    void findByTime_NonExistingLine_ShouldReturnOptionalEmpty() {
        // given
        when(redLineRepository.findByTime(any())).thenReturn(Optional.empty());

        // when
        Optional<RedLine> result = redLineRepository.findByTime(any());

        // then
        assertTrue(result.isEmpty());
    }

}
