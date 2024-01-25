package com.oscar.helloworld.controller;

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

    @GetMapping("/hello")
    public String getHello(){
        return helloService.hello();
    }

    @GetMapping("/hello2")
    public Mono<String> getHello2(){
        return helloService.hello2();
    }

}

