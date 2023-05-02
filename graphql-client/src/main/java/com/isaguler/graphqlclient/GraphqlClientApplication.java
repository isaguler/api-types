package com.isaguler.graphqlclient;

import com.isaguler.graphqlclient.model.Country;
import com.isaguler.graphqlclient.repository.CountryRepository;
import com.isaguler.graphqlclient.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class GraphqlClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlClientApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CountryService service, CountryRepository repository) {
		return args -> {
			Mono<List<Country>> countries = service.getCountries();
			countries.subscribe(repository::saveAll);
		};
	}

}
