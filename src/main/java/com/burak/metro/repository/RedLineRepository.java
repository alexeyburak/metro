package com.burak.metro.repository;

import com.burak.metro.model.RedLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface RedLineRepository extends JpaRepository<RedLine, Long> {
    @Query(
            value = "SELECT * " +
                    "FROM red_line l " +
                    "WHERE :lt " +
                    "BETWEEN l.beginning_time_period " +
                    "AND l.end_time_period",
            nativeQuery = true
    )
    Optional<RedLine> findByTime(@Param("lt") LocalTime now);
}
