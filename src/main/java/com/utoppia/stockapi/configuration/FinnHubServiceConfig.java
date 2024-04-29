package com.utoppia.stockapi.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FinnHubServiceConfig {

    @Value("${finnhub.base.url}")
    private String finnHubBaseUrl;

    @Bean
    public WebClient finnHubWebClient() {
        return WebClient.builder().baseUrl(finnHubBaseUrl).build();
    }

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}
