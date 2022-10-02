package com.example.arcadialogin.controller;

import com.example.arcadialogin.domain.Condominio;
import com.example.arcadialogin.repository.CondominioRepository;
import com.example.arcadialogin.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/condominios")
public class CondominioController {
    @Autowired
    private CondominioRepository condominioRepository;
    @Autowired
    private MoradorRepository moradorRepository;

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
    @GetMapping("/{nome}/moradores")
    public ResponseEntity<Object> getMoradores(@PathVariable String nome) {
        Condominio condominio = condominioRepository.findByNome(nome);
        if (condominio != null) {
            return ResponseEntity.status(200).body(moradorRepository.findByCondominio(condominio));
        }
        return ResponseEntity.status(404).body("Condominio não encontrado");
    }
}
