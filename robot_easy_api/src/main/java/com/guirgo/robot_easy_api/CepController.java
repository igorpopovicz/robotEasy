package com.guirgo.robot_easy_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guirgo.robot_easy_api.CepRequest;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/cep")
public class CepController {
    
    @Autowired
    private CepService cepService;

    @GetMapping("/get")
    public ResponseEntity<CepModel> getCep(@RequestParam String cep) {

        try {
            return ResponseEntity.ok(cepService.getCep(cep));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
