package Arcadia.Lira;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    Condominio condominio = new Condominio("Sptech","SP","Santo antonio",
            "Itaquera",123);

    @PostMapping("/cadastrarMorador")
    public String postMorador(@RequestBody Morador newUsuario){

        for (Usuario usuario : condominio.getUsuarios()){
            if (usuario.getEmail().equals(newUsuario.getEmail())){
                return "Usuário já cadastrado com esse email!";
            }
        }
        condominio.cadastrarMorador(newUsuario);
        return "Morador cadastrado com sucesso!";
    }

    @PostMapping("/cadastrarPorteiro")
    public String postPorteiro(@RequestBody Porteiro newUsuario){

        for (Usuario usuario : condominio.getUsuarios()){
            if (usuario.getEmail().equals(newUsuario.getEmail())){
                return "Usuário já cadastrado com esse email!";
            }
        }
        condominio.cadastrarPorteiro(newUsuario);
        return "Porteiro cadastrado com sucesso!";
    }

    @PostMapping("/autenticacao/{email}/{senha}")
    public Usuario autenticarUsuario(@PathVariable String email,
                                     @PathVariable String senha){
        for (Usuario usuario1 : condominio.getUsuarios()){
            if (email.equals(usuario1.getEmail()) && usuario1.validarSenha(senha)){
                usuario1.setAutenticado(true);
                return usuario1;
            }
        }
        return null;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return condominio.getUsuarios();
    }

    @DeleteMapping("/autenticacao/{email}")
    public String logoffUsuario(@PathVariable String email){
        for (Usuario usuario1 : condominio.getUsuarios()){
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
        List<Usuario> autenticados = condominio.getUsuarios().stream()
                .filter(usuario -> usuario.getAutenticado().equals(true))
                .collect(Collectors.toList());
        return autenticados;
    }

}
