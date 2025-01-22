package com.currency.converter.Currency.Cunverter5.Service;

import com.currency.converter.Currency.Cunverter5.Model.ConversionRequest;
import com.currency.converter.Currency.Cunverter5.Model.ConversionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

public class CurrencyService {



    @Value("${external.api.url}")
    private String apiUrl;

    public Map<String, Double> getExchangeRates(String base) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + "/" + base;
        Map response = restTemplate.getForObject(url, Map.class);
        return (Map<String, Double>) response.get("rates");
    }

    public ConversionResponse convertCurrency(ConversionRequest request) {
        Map<String, Double> rates = getExchangeRates(request.getFrom());
        Double rate = rates.get(request.getTo());
        if (rate == null) {
            throw new IllegalArgumentException("Invalid target currency");
        }
        double convertedAmount = request.getAmount() * rate;
        return new ConversionResponse(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount);
    }
}
