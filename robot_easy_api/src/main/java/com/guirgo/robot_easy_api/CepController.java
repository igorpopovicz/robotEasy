package com.guirgo.robot_easy_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
public class CepController {
    
    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<CepModel> getCep(@PathVariable String cep) {
        return ResponseEntity.ok(cepService.getCep(cep));
    }
}
