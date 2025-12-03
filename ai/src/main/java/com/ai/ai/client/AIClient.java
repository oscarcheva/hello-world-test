package com.ai.ai.client;

import com.google.genai.Client;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.genai.Client;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIClient {


        private final String openAIKEY;

        private final String GeminiAIKEY;

        public AIClient(@Value("${openai.api.key:${OPENAI_API_KEY}}") String apiKeyOpenAI,
                        @Value("${gemini.api.key:${GEMINI_API_KEY}}") String apiKeyGemini) {
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
