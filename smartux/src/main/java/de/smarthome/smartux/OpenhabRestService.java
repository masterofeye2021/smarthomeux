package de.smarthome.smartux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import de.smarthome.smartux.mainDataModel.OpenhabItem;
import reactor.core.publisher.Mono;

@Service
public class OpenhabRestService {

    @Autowired
    private WebClient webClient;
    
    @Value("${openhab.url}")
    private final String openHabUrl = "http://<openhab-server-ip>:8080/rest/";

    public Mono<String> getItems() {
        return webClient
            .get()
            .uri("items") // API-Endpunkt für alle Items
            .retrieve()
            .bodyToMono(String.class); // Antwort als String zurückgeben (kann angepasst werden)
    }

    public Mono<OpenhabItem> getItemDetails(String itemName) {
        return webClient
            .get()
            .uri("/items/{itemName}", itemName) // Platzhalter für Item-Namen
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(OpenhabItem.class); // Antwort als String zurückgeben
    }
}