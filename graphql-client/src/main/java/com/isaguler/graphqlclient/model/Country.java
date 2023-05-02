package com.isaguler.graphqlclient.model;

import org.springframework.data.annotation.Id;

public record Country(
        @Id
        Integer id,
        String name,
        String currency,
        String code
) {
}
