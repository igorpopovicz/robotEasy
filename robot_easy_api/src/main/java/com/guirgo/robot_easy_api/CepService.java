package com.guirgo.robot_easy_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CepService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Cacheable(value = "cepCache", key = "#cep")
    public CepModel getCep(String cep) {
        return webClientBuilder.build()
                .get()
                .uri("https://viacep.com.br/ws/" + cep + "/json/")
                .retrieve()
                .bodyToMono(CepModel.class)
                .block();
    }
}
