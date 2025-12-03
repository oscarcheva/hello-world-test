package com.ai.ai.service;

import com.ai.ai.DTO.ChatRequestDTO;
import com.ai.ai.DTO.ChatResponseDTO;
import com.ai.ai.DTO.MenuDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.Client;
import com.openai.client.OpenAIClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AIService {

    private final Client geminiClient;

    public ChatCompletion chatGPTResponse(OpenAIClient client) {

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage("Please tell me the next 5 leap years")
                .model(ChatModel.GPT_4_1)
                .build();
        return client.chat().completions().create(params);
    }

    public Mono<String> getHello() {
        return Mono.justOrEmpty("Hello world");
    }

    public Mono<ChatResponseDTO> geminiChat(ChatRequestDTO promptBody) {

        return Mono.fromCallable(() ->
                        geminiClient.models.generateContent("gemini-2.5-flash", promptBody.getPrompt(), null)
                )
                .map(ChatResponseDTO::from);
    }

    public Mono<ChatResponseDTO> geminiResponse(ChatRequestDTO promptBody, Flux<MenuDTO> menuDTO) {

        return menuDTO
                .collectList()
                .map(list -> {
                    try {
                        return new ObjectMapper().writeValueAsString(list);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(json -> """
                        %s
                        %s
                        """.formatted(promptBody.getPrompt(), json))
                .flatMap(completePrompt ->
                        Mono.fromCallable(() ->
                                geminiClient.models.generateContent("gemini-2.5-flash", completePrompt, null)
                        ))
                .map(ChatResponseDTO::from);
    }

}

