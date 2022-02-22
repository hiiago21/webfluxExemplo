package com.apirest.webflux.controller;

import com.apirest.webflux.document.Categoria;
import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.services.PlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/playlist")
@RequiredArgsConstructor
public class PlayListController {

    private final PlayListService service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long,PlayList>> getPlaylist(){
        Flux<Long> intervalo = Flux.interval(Duration.ofSeconds(1));
        return Flux.zip(intervalo, service.findAll().limitRate(100));
    }

    @GetMapping(value="/{id}")
    public Mono<PlayList> getPlaylistId(@PathVariable String id){
        return service.findById(id);
    }

    @PostMapping
    public Mono<PlayList> save(@RequestBody PlayList playlist){
        return service.save(playlist);
    }

    @GetMapping(value = "/categorias", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<List<Categoria>>> findAll(){
        return Flux.interval(Duration.ofSeconds(5))
                .map(sequence -> ServerSentEvent.<List<Categoria>>builder()
                        .id(String.valueOf(sequence))
                        .data(service.findAllCategorias())
                        .build());
    }

}
