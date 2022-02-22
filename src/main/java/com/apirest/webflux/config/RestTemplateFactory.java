package com.apirest.webflux.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class RestTemplateFactory {

    public static RestTemplate clientCategoria(){
    RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8081")
                .build();
        return restTemplate;
   }
}
