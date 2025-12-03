package com.ai.ai.client;

import com.ai.ai.DTO.MenuDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
public class MenuWebClient {

    private final WebClient webClient;

    public MenuWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://menu-api:9090").build();
    }

    public Flux<MenuDTO> getAllMenus() {
        return webClient.get()
                .uri("/v1/all")
                .retrieve()
                .bodyToFlux(MenuDTO.class);
    }

}
