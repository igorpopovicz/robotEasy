package com.guirgo.robot_easy_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CepService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    
    private final WebClient webClient;

    public CepService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://viacep.com.br/ws").build();
    }

    @Cacheable(value = "cepCache", key = "#cep")
    public CepModel getCep(String cep) {
        if (cep == null || cep.isEmpty()) {
            throw new IllegalArgumentException("CEP não pode ser nulo ou vazio");
        }

        return this.webClient.get()
                .uri("/{cep}/json/", cep)
                .retrieve()
                .bodyToMono(CepModel.class)
                .block();
    }

    
}
