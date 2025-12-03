package com.ai.ai.service;

import com.ai.ai.DTO.MenuDTO;
import com.ai.ai.client.MenuWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuWebClient webClient;

    public Flux<MenuDTO> getAllMenus() {
        return webClient.getAllMenus();
    }
}
