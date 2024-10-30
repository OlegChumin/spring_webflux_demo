package org.example.spring_webflux_demo.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@RestController
public class WebFluxController {

    @GetMapping("/process")
    public Mono<String> processRequest() {
        log.info("Received request in WebFluxController");
        // Имитируем задержку обработки с использованием Mono
        return Mono.just("Processed by WebFlux")
                .delayElement(Duration.ofMillis(500))
                .doOnNext(result -> log.info("Completed processing request in WebFluxController"));
    }
}
