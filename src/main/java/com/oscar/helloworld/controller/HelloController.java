package com.oscar.helloworld.controller;

import com.google.genai.types.GenerateContentResponse;
import com.openai.models.chat.completions.ChatCompletion;
import com.oscar.helloworld.DTO.ChatRequestDTO;
import com.oscar.helloworld.DTO.ChatResponseDTO;
import com.oscar.helloworld.config.AIConfig;
import com.oscar.helloworld.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;
    private final AIConfig config;

    @GetMapping("/hello")
    public String getHello() {
        return helloService.hello();
    }

    @GetMapping("/hello2")
    public Mono<String> getHello2() {
        return helloService.hello2();
    }

    @GetMapping("/chatgpt")
    public ChatCompletion getChatGPTResponse() {
        return helloService.chatGPTResponse(config.openAI());

    }

    @PostMapping("/gemini")
    public ChatResponseDTO getGeminiResponse(@RequestBody ChatRequestDTO promptBody) {
        return helloService.geminiResponse(config.GeminiClient(),promptBody);

    }

}

