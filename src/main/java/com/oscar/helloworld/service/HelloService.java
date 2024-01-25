package com.oscar.helloworld.service;

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
}
