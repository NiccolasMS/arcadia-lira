package Arcadia.Lira;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    Condominio condominio = new Condominio("Sptech","SP","Santo antonio",
            "Itaquera",123);


    @PostMapping("/cadastrarMorador")
    public ResponseEntity postMorador(@RequestBody Morador newUsuario){
        if(newUsuario.isValido())
        {
            for (Usuario usuario : condominio.getUsuarios()){
                if (usuario.getEmail().equals(newUsuario.getEmail())){
                    return ResponseEntity.status(400).body("Usuário já cadastrado com esse email!");
                }
            }
            condominio.cadastrarMorador(newUsuario);
            //201 CREATED, geralmente utilizada com post
            return ResponseEntity.status(201).body("Morador cadastrado com sucesso!\n"  + newUsuario);
        }
        else {
            //BAD REQUEST
            return ResponseEntity.status(400).body("usuario e senha devem ter 3+ letras");
        }

    }

    @PostMapping("/cadastrarPorteiro")
    public ResponseEntity postPorteiro(@RequestBody Porteiro newUsuario){

        if(newUsuario.isValido())
        {
            for (Usuario usuario : condominio.getUsuarios()){
                if (usuario.getEmail().equals(newUsuario.getEmail())){
                    return ResponseEntity.status(400).body("Usuário já cadastrado com esse email!");
                }
            }
            condominio.cadastrarPorteiro(newUsuario);
            //201 CREATED, geralmente utilizada com post
            return ResponseEntity.status(201).body("Porteiro cadastrado com sucesso!\n"  + newUsuario);
        }
        else {
            //BAD REQUEST
            return ResponseEntity.status(400).body("usuario e senha devem ter 3+ letras");
        }
    }

    @PostMapping("/autenticacao/{email}/{senha}")
    public ResponseEntity<Usuario> autenticarUsuario(@PathVariable String email,
                                                     @PathVariable String senha){
        for (Usuario usuario1 : condominio.getUsuarios()){
            if (email.equals(usuario1.getEmail()) && usuario1.validarSenha(senha)){
                usuario1.setAutenticado(true);
                return ResponseEntity.status(200).body(usuario1);
            }
        }
        //401 não autorizado
        return ResponseEntity.status(401).build();
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        //204 sem conteúdo
        return condominio.getUsuarios().isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(condominio.getUsuarios());
    }

    @DeleteMapping("/autenticacao/{email}")
    public ResponseEntity logoffUsuario(@PathVariable String email){
        for (Usuario usuario1 : condominio.getUsuarios()){
            if (email.equals(usuario1.getEmail()) && usuario1.getAutenticado().equals(true)){
                usuario1.setAutenticado(false);
                return ResponseEntity.status(200).body("Logoff do usuário " + usuario1.getNome() + " concluído");
            }
            if (email.equals(usuario1.getEmail()) && usuario1.getAutenticado().equals(false)){
                //401 não autenticado, cliente deve autenticar para receber uma resposta
                return ResponseEntity.status(401).body("Usuário " + usuario1.getNome() + " NÃO está autenticado");
            }
        }
        //404 não encontrado
        return ResponseEntity.status(404).body("Usuário " + email + " não encontrado");
    }

    @GetMapping("/autenticados")
    public ResponseEntity<List<Usuario>> autenticados(){
        List<Usuario> autenticados = condominio.getUsuarios().stream()
                .filter(usuario -> usuario.getAutenticado().equals(true))
                .collect(Collectors.toList());

        return autenticados.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(condominio.getUsuarios());

    }

}
