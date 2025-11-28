package com.oscar.helloworld.config;

import com.openai.client.OpenAIClient;
import com.openai.client.OpenAIClientImpl;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.openai.credential.BearerTokenCredential;

@Configuration
public class OpenAIConfig {

    private final String apiKey;

    public OpenAIConfig(@Value("${openai.api.key:${OPENAI_API_KEY}}") String apiKey) {
        this.apiKey = apiKey;
    }

    @Bean
    public OpenAIClient openAI() {
        return OpenAIOkHttpClient.builder()
                .apiKey(apiKey)
                .build();
    }
}
