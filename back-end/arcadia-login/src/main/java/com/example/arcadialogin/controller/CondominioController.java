package com.example.arcadialogin.controller;

import com.example.arcadialogin.domain.Condominio;
import com.example.arcadialogin.repository.CondominioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/condominios")
public class CondominioController {
    @Autowired
    private CondominioRepository condominioRepository;

    @PostMapping
    public ResponseEntity<Object> postCondominio(@RequestBody Condominio condominio) {
        if (condominioRepository.findById(condominio.getId()).isPresent()) {
            return ResponseEntity.status(200).body("Condominio já cadastrado");
        }
        condominioRepository.save(condominio);
        return ResponseEntity.status(201).body(condominio);
    }

    @GetMapping
    public ResponseEntity<Object> getCondominios() {
        if (condominioRepository.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(condominioRepository.findAll());
    }
}
