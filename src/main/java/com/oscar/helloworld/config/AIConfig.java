package com.oscar.helloworld.config;

import com.google.genai.Client;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    private final String openAIKEY;

    private final String GeminiAIKEY;

    public AIConfig(@Value("${openai.api.key:${OPENAI_API_KEY}}") String apiKeyOpenAI,
                    @Value("${gemini.key:${GEMINI_KEY}}") String apiKeyGemini) {
        this.openAIKEY = apiKeyOpenAI;
        this.GeminiAIKEY = apiKeyGemini;
    }

    @Bean
    public OpenAIClient openAI() {
        return OpenAIOkHttpClient.builder()
                .apiKey(openAIKEY)
                .build();
    }

    @Bean
    public Client GeminiClient() {
        return Client.builder()
                .apiKey(GeminiAIKEY)
                .build();
    }
}
