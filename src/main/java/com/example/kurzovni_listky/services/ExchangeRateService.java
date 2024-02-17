package com.example.kurzovni_listky.services;

import com.example.kurzovni_listky.models.ExchangeRate;
import com.example.kurzovni_listky.repositories.ExchangeRateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ExchangeRateService {

    private final ExchangeRateRepo exchangeRateRepo;
    private final RestTemplate restTemplate;
    private final String apiUrl = "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e";

    @Autowired
    public ExchangeRateService(ExchangeRateRepo exchangeRateRepo, RestTemplate restTemplate) {
        this.exchangeRateRepo = exchangeRateRepo;
        this.restTemplate = restTemplate;
    }

    public List<ExchangeRate> getAllExchangeRates() {
        return exchangeRateRepo.findAll();
    }

    public void updateExchangeRates() {
        ExchangeRate[] ratesFromApi = restTemplate.getForObject(apiUrl, ExchangeRate[].class);
        if (ratesFromApi == null) return;

        List<ExchangeRate> existingRates = exchangeRateRepo.findAll();
        Map<String, ExchangeRate> existingRatesMap = existingRates.stream()
                .collect(Collectors.toMap(ExchangeRate::getShortName, rate -> rate));

        for (ExchangeRate rateFromApi : ratesFromApi) {
            ExchangeRate existingRate = existingRatesMap.get(rateFromApi.getShortName());

            if (existingRate == null) {
                exchangeRateRepo.save(rateFromApi);
            } else if (!existingRate.getValidFrom().equals(rateFromApi.getValidFrom())) {
                overwriteExistingRate(existingRate, rateFromApi);
                exchangeRateRepo.save(existingRate);
            }
        }
    }

    private void overwriteExistingRate(ExchangeRate existingRate, ExchangeRate newRate) {
            existingRate.setName(newRate.getName());
            existingRate.setValidFrom(newRate.getValidFrom());
            existingRate.setCountry(newRate.getCountry());
            existingRate.setMove(newRate.getMove());
            existingRate.setAmount(newRate.getAmount());
            existingRate.setValBuy(newRate.getValBuy());
            existingRate.setValSell(newRate.getValSell());
            existingRate.setValMid(newRate.getValMid());
            existingRate.setCurrBuy(newRate.getCurrBuy());
            existingRate.setCurrSell(newRate.getCurrSell());
            existingRate.setCurrMid(newRate.getCurrMid());
            existingRate.setVersion(newRate.getVersion());
            existingRate.setCnbMid(newRate.getCnbMid());
            existingRate.setEcbMid(newRate.getEcbMid());
        }
}

