package com.currency.converter.Currency.Cunverter5.Controller;

import com.currency.converter.Currency.Cunverter5.Service.CurrencyService;
import com.currency.converter.Currency.Cunverter5.Model.ConversionResponse;
import com.currency.converter.Currency.Cunverter5.Model.ConversionRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rates")
    public Map<String, Double> getExchangeRates(@RequestParam(value = "base", defaultValue = "USD") String base) {
        return currencyService.getExchangeRates(base);
    }

    @PostMapping("/convert")
    public ConversionResponse convertCurrency(@RequestBody ConversionRequest request) {
        return currencyService.convertCurrency(request);
    }
}
