package de.smarthome.smartux.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${openhab.api.token}")
    private String apiToken;

    @Value("${openhab.url}")
    private String openhabUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
        .baseUrl(openhabUrl)
        .defaultHeader("Authorization", "Bearer " + apiToken)
        .build();
    }
}