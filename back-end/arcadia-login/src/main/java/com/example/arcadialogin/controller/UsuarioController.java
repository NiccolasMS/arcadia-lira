package com.example.arcadialogin.controller;

import com.example.arcadialogin.domain.Usuario;
import com.example.arcadialogin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
    @Autowired
    private UsuarioRepository UsuarioRepository;

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody Usuario usuario) {
        if (UsuarioRepository.findByEmail(usuario.getEmail()) != null) {
            return ResponseEntity.status(200).body("Email já cadastrado");
        }
        UsuarioRepository.save(usuario);
        return ResponseEntity.status(201).body(usuario);
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        if (UsuarioRepository.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(UsuarioRepository.findAll());
    }

    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Usuario usuario){
        Usuario usuarioLogin = UsuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioLogin != null) {
            if (usuarioLogin.senha().equals(usuario.senha())) {
                usuarioLogin.setAutenticado(true);
                return ResponseEntity.status(200).body(UsuarioRepository.save(usuarioLogin));
            } else {
                return ResponseEntity.status(401).body("Usuário ou senha incorretos");
            }
        }
        return ResponseEntity.status(404).body(null);
    }
}
