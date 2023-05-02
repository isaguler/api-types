package com.isaguler.graphqlclient.repository;

import com.isaguler.graphqlclient.model.Country;
import org.springframework.data.repository.ListCrudRepository;

public interface CountryRepository extends ListCrudRepository<Country, Integer> {
}
