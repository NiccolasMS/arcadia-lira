package com.example.arcadia;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    List<Usuario> usuarios = new ArrayList<>();

    @PostMapping
    public String postUsuario(@RequestBody Usuario newUsuario){
        for (Usuario usuario : usuarios){
            if (usuario.getEmail().equals(newUsuario.getEmail())){
                return "Usuário já cadastrado com esse email!";
            }
        }
        usuarios.add(newUsuario);
        return "Usuário cadastrado com sucesso!";
    }

    @PostMapping("/autenticacao/{email}/{senha}")
    public Usuario autenticarUsuario(@PathVariable String email,
                                     @PathVariable String senha){
        for (Usuario usuario1 : usuarios){
            if (email.equals(usuario1.getEmail()) && usuario1.validarSenha(senha)){
                usuario1.setAutenticado(true);
                return usuario1;
            }
        }
        return null;
    }

    @GetMapping
    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    @DeleteMapping("/autenticacao/{email}")
    public String logoffUsuario(@PathVariable String email){
        for (Usuario usuario1 : usuarios){
            if (email.equals(usuario1.getEmail()) && usuario1.getAutenticado().equals(true)){
                usuario1.setAutenticado(false);
                return "Logoff do usuário " + usuario1.getNome() + " concluído";
            }
            if (email.equals(usuario1.getEmail()) && usuario1.getAutenticado().equals(false)){
                return "Usuário " + usuario1.getNome() + " NÃO está autenticado";
            }
        }
        return "Usuário " + email + " não encontrado";
    }

    @GetMapping("/autenticados")
    public List<Usuario> autenticados(){
        List<Usuario> autenticados = usuarios.stream()
                .filter(usuario -> usuario.getAutenticado().equals(true))
                .collect(Collectors.toList());
        return autenticados;
    }
}
