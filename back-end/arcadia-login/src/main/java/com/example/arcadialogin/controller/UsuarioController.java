package com.example.arcadialogin.controller;

import com.example.arcadialogin.model.Usuario;
import com.example.arcadialogin.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
    @Autowired
    private IUsuarioRepository IUsuarioRepository;

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody Usuario usuario) {
        if (IUsuarioRepository.findByEmail(usuario.getEmail()) != null) {
            return ResponseEntity.status(200).body("Email já cadastrado");
        }
        IUsuarioRepository.save(usuario);
        return ResponseEntity.status(201).body(usuario);
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        if (IUsuarioRepository.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(IUsuarioRepository.findAll());
    }

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity<Object> login(@PathVariable String email,
                                        @PathVariable String senha) {
           Usuario usuario = IUsuarioRepository.findByEmail(email);
              if (usuario != null) {
                  if (usuario.senha().equals(senha)) {
                      return ResponseEntity.status(200).body("Login realizado com sucesso!");
                  } else {
                      return ResponseEntity.status(401).body("Senha incorreta");
                  }
              }
              return ResponseEntity.status(404).body("Usuário não encontrado");
    }
}
