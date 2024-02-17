package com.example.kurzovni_listky.controllers;

import com.example.kurzovni_listky.models.ExchangeRate;
import com.example.kurzovni_listky.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exchange-rates")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public List<ExchangeRate> getExchangeRates(@RequestParam(required = false) boolean usedb) {
        if (usedb) {
            // data z databáze
            return exchangeRateService.getAllExchangeRates();
        } else {
            // data z externího API a vrátí aktualizovaná data
            exchangeRateService.updateExchangeRates();
            return exchangeRateService.getAllExchangeRates();
        }
    }
}

