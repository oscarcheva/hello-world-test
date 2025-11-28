package com.oscar.helloworld.controller;

import com.openai.models.chat.completions.ChatCompletion;
import com.oscar.helloworld.config.OpenAIConfig;
import com.oscar.helloworld.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;
    private final OpenAIConfig config;

    @GetMapping("/hello")
    public String getHello() {
        return helloService.hello();
    }

    @GetMapping("/hello2")
    public Mono<String> getHello2() {
        return helloService.hello2();
    }

    @GetMapping("/chat")
    public ChatCompletion getChatResponse() {
        return helloService.chatGPTResponse(config.openAI());

    }

}

