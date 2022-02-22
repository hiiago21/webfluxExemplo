package com.apirest.webflux.services;

import com.apirest.webflux.config.RestTemplateFactory;
import com.apirest.webflux.document.Categoria;
import com.apirest.webflux.document.PlayList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PlayListService {

    Flux<PlayList> findAll();
    Mono<PlayList> findById(String id);
    Mono<PlayList> save(PlayList playList);
    List<Categoria> findAllCategorias();
}
