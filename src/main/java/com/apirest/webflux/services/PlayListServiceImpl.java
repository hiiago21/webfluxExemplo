package com.apirest.webflux.services;

import com.apirest.webflux.config.RestTemplateFactory;
import com.apirest.webflux.document.Categoria;
import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.repository.PlayListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PlayListServiceImpl implements PlayListService{

    private final PlayListRepository repository;

    @Override
    public Flux<PlayList> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<PlayList> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<PlayList> save(PlayList playList) {
        return repository.save(playList);
    }

    @Override
    public List<Categoria> findAllCategorias() {
        Categoria[] forEntity = RestTemplateFactory.clientCategoria().getForObject("/categorias", Categoria[].class);
        return Arrays.asList(forEntity);
    }
}
