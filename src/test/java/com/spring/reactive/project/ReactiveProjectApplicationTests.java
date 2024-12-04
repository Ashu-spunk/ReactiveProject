package com.spring.reactive.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void workingWithMono() {

//        //Mono is a publisher that have 0 or 1 value
//        //Creating Mono
//        Mono<String> m1 = Mono
//                .just("Hello Ashutosh lets learn reactive programming...")
//                .log();
//
//
//        Mono<Object> errorMono = Mono.error(new RuntimeException("Error !!!"));
//
//
//
//        //consume the Mono value by subscribing to it
//        m1.subscribe(System.out::println);
//
//        errorMono.subscribe(System.out::println);

        Mono<String> m1 = Mono.just("Hello Ashutosh lets learn reactive programming...");
        Mono<String> m2 = Mono.just("Lets work with reactive streams...");
        Mono<Integer> m3 = Mono.just(2758943);

        Mono<String> resultMapMono = m1.map(value ->value.toUpperCase());
        resultMapMono.subscribe(System.out::println);

        Mono<String[]> resultFlatMapExample = m1.flatMap(value1-> Mono.just(value1.split(" ")));
        resultFlatMapExample.subscribe(data ->
        {
            for (String s : data) {
                System.out.println(s);
            }
        });

        System.out.println("---------------------------------------------------------------");

        Flux<String> stringFlux = m1.flatMapMany(value1-> Flux.just(value1.split(" "))).log();
        stringFlux.subscribe(data ->
                System.out.println(data));
    }

}
