package com.ai.ai.controller;

import com.ai.ai.DTO.ChatRequestDTO;
import com.ai.ai.DTO.ChatResponseDTO;
import com.ai.ai.DTO.MenuDTO;
import com.ai.ai.service.AIService;
import com.ai.ai.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AppController {

    private final MenuService menuService;
    private final AIService aiService;

    @GetMapping("/menu")
    public Flux<MenuDTO> getAllMenus() {
        return menuService.getAllMenus();
    }

    @PostMapping("/chat")
    public Mono<ChatResponseDTO> geminiChat(@RequestBody ChatRequestDTO promptBody) {

        return aiService.geminiChat(promptBody);

    }

    @PostMapping("/gemini")
    public Mono<ChatResponseDTO> getGeminiResponse(@RequestBody ChatRequestDTO promptBody) {

        return aiService.geminiResponse(promptBody, menuService.getAllMenus());

    }

    @GetMapping("/hello")
    public Mono<String> getHello() {

        return aiService.getHello();

    }
}
