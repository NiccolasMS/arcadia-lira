package com.example.arcadialogin.controller;

import com.example.arcadialogin.domain.Morador;
import com.example.arcadialogin.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moradores")
public class MoradorController {
    @Autowired
    private MoradorRepository moradorRepository;

    @PostMapping
    public ResponseEntity<Object> postMorador(@RequestBody Morador morador) {
        if (moradorRepository.findById(morador.getId()).isPresent()) {
            return ResponseEntity.status(200).body("Morador já cadastrado");
        }
        moradorRepository.save(morador);
        return ResponseEntity.status(201).body(morador);
    }
}
