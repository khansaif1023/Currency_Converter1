package com.currency.converter.Currency.Cunverter5;

import org.springframework.boot.SpringApplication;

public class TestCurrencyCunverter5Application {

	public static void main(String[] args) {
		SpringApplication.from(CurrencyCunverter5Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
