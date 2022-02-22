//package com.apirest.webflux;
//
//import com.apirest.webflux.document.PlayList;
//import com.apirest.webflux.services.PlayListService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
//import static org.springframework.web.reactive.function.server.ServerResponse.ok;
//
////@Component
////@RequiredArgsConstructor
//public class PlayListHandler {
//
//    private  PlayListService playListService;
//
//    public Mono<ServerResponse> findAll(ServerRequest request){
//        return  ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(playListService.findAll(), PlayList.class);
//    }
//
//    public Mono<ServerResponse> findById(ServerRequest request){
//        return  ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(playListService.findById(request.pathVariable("id")), PlayList.class);
//    }
//
//    public Mono<ServerResponse> save(ServerRequest request){
//        final Mono<PlayList> playListSave = request.bodyToMono(PlayList.class);
//        return  ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(fromPublisher(playListSave.flatMap(playListService::save), PlayList.class));
//    }
//}
