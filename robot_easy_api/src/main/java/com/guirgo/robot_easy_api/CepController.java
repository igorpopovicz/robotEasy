package com.guirgo.robot_easy_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guirgo.robot_easy_api.CepRequest;

@RestController
@RequestMapping("/api/cep")
public class CepController {
    
    @Autowired
    private CepService cepService;

    @GetMapping("/get")
    public ResponseEntity<CepModel> getCep(@RequestBody CepRequest cepRequest) {

        return ResponseEntity.ok(cepService.getCep(cepRequest.getCep()));
    }
}
