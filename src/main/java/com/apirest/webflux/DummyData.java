//package com.apirest.webflux;
//
//import com.apirest.webflux.document.PlayList;
//import com.apirest.webflux.repository.PlayListRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//
//import java.util.UUID;
//
//@Component
//@RequiredArgsConstructor
//public class DummyData implements CommandLineRunner {
//
//    private final PlayListRepository repository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        repository.deleteAll()
//                .thenMany(
//                        Flux.just("API REST Spring Boot", "Deploy de uma aplicação java no IBM Cloud", "Java 8",
//                                "Github", "Spring Security", "Web Service RESTFULL", "Bean no Spring Framework")
//                                .map(nome -> new PlayList(UUID.randomUUID().toString(), nome))
//                                .flatMap(repository::save))
//                .subscribe(System.out::println);
//    }
//}
