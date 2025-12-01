package com.oscar.helloworld.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.openai.client.OpenAIClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.oscar.helloworld.DTO.ChatRequestDTO;
import com.oscar.helloworld.DTO.ChatResponseDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HelloService {

    public String hello() {
        return "Hello World";
    }

    public Mono<String> hello2() {
        return Mono.just("Hello World 2");
    }

    public ChatCompletion chatGPTResponse(OpenAIClient client) {

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage("Please tell me the next 5 leap years")
                .model(ChatModel.GPT_4_1)
                .build();
        return client.chat().completions().create(params);
    }

    public ChatResponseDTO geminiResponse(Client client, ChatRequestDTO promptBody) {

        ObjectMapper objectMapper = new ObjectMapper();

        GenerateContentResponse response = client.models.generateContent("gemini-2.5-flash", promptBody.getPrompt(), null);

        return ChatResponseDTO.from(response);

    }
}
