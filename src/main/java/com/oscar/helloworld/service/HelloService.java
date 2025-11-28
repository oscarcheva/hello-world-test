package com.oscar.helloworld.service;

import com.openai.client.OpenAIClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
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

    public ChatCompletion chatGPTResponse(OpenAIClient client){

        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .addUserMessage("Please tell me the next 5 leap years")
                .model(ChatModel.GPT_4)
                .build();
        return client.chat().completions().create(params);
    }
}
