package com.example.kurzovni_listky.repositories;

import com.example.kurzovni_listky.models.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExchangeRateRepo extends JpaRepository<ExchangeRate, Long> {
    List<ExchangeRate> findByShortNameAndValidFrom(String shortName, LocalDateTime validFrom);
}
