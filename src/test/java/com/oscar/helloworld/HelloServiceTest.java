package com.oscar.helloworld;

import com.oscar.helloworld.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class HelloServiceTest {

    HelloService helloService = new HelloService();

    @Test
    void testHello() {
        Assertions.assertEquals("Hello World", helloService.hello());
    }

    @Test
    void testHello2() {
        StepVerifier.create(helloService.hello2())
                .expectNext("Hello World 2")
                .expectComplete();
    }
}
