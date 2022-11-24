package com.burak.metro.repository;

import com.burak.metro.model.RedLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

public interface RedLineRepository extends JpaRepository<RedLine, Long> {
    @Query(value = "SELECT * FROM red_line WHERE ?1 BETWEEN beginning_time_period AND end_time_period",
            nativeQuery = true)
    RedLine findLineByCurrentTime(LocalTime now);
}
