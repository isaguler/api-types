package com.isaguler.graphqlclient.service;

import com.isaguler.graphqlclient.model.Country;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.management.monitor.MonitorNotification;
import java.util.List;

@Service
public class CountryService {

    private final HttpGraphQlClient graphQlClient;

    public CountryService() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com")
                .build();

        graphQlClient = HttpGraphQlClient.builder(webClient).build();
    }

    public Mono<List<Country>> getCountries() {
        String document = """
                query {
                    countries {
                        name
                        emoji
                        currency
                        code
                        capital
                    }
                }
                """;

        Mono<List<Country>> countries = graphQlClient.document(document)
                .retrieve("countries")
                .toEntityList(Country.class);

        return countries;
    }
}
