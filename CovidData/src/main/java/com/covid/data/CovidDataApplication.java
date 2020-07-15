package com.covid.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.covid.data.service.CountryService;

@SpringBootApplication
public class CovidDataApplication implements CommandLineRunner{

	
	@Autowired
	private CountryService countryService;
	
	public static void main(String[] args) {
		SpringApplication.run(CovidDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		countryService.readCountryCovidData();
		
  }

}
