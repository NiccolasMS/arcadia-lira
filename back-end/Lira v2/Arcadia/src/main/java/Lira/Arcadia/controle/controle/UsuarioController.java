package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Encomenda;
import Lira.Arcadia.controle.dominio.Morador;
import Lira.Arcadia.controle.dominio.Porteiro;
import Lira.Arcadia.controle.dominio.Usuario;
import Lira.Arcadia.controle.repositorio.EncomendaRepository;
import Lira.Arcadia.controle.repositorio.MoradorRepository;
import Lira.Arcadia.controle.repositorio.PorteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private MoradorRepository moradorRepository;
    @Autowired
    private PorteiroRepository porteiroRepository;

    @Autowired
    private EncomendaRepository encomendaRepository;

    @PostMapping("/cadastrarMorador")
    public ResponseEntity postMorador(@RequestBody Morador newUsuario){

            for (Usuario usuario : moradorRepository.findAll()){
                if (usuario.getEmail().equals(newUsuario.getEmail())){
                    return ResponseEntity.status(400).body("Morador já cadastrado com esse email!");
                }
            }
            moradorRepository.save(newUsuario);
            //201 CREATED, geralmente utilizada com post
            return ResponseEntity.status(201).body("Morador cadastrado com sucesso!\n"  + newUsuario);
    }

    @PostMapping("/cadastrarPorteiro")
    public ResponseEntity postPorteiro(@RequestBody Porteiro newUsuario){

            for (Usuario usuario : porteiroRepository.findAll()){
                if (usuario.getEmail().equals(newUsuario.getEmail())){
                    return ResponseEntity.status(400).body("Porteiro já cadastrado com esse email!");
                }
            }
            porteiroRepository.save(newUsuario);
            //201 CREATED, geralmente utilizada com post
            return ResponseEntity.status(201).body("Porteiro cadastrado com sucesso!\n"  + newUsuario);
    }

    @GetMapping("/moradores")
    public ResponseEntity<List<Morador>> getMoradores(){
        List<Morador> moradores = moradorRepository.findAll();
        //204 sem conteúdo
        return moradores.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(moradores);
    }

    @GetMapping("/porteiros")
    public ResponseEntity<List<Porteiro>> getPorteiros(){
        List<Porteiro> porteiros = porteiroRepository.findAll();
        //204 sem conteúdo
        return porteiros.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(porteiros);
    }


    @PutMapping("/logoffMorador/{email}")
    public ResponseEntity<Object> logoffMorador(@PathVariable String email){
        Morador morador1 = moradorRepository.findByEmail(email);
        if (morador1 != null){
            if (morador1.getAutenticado()){
                morador1.setAutenticado(false);
                moradorRepository.save(morador1);
                return ResponseEntity.status(200).body("Morador deslogado com sucesso!");
            }else {
                return ResponseEntity.status(400).body("Morador não está logado!");
            }
        }
        return ResponseEntity.status(400).body("Morador não encontrado!");
    }

    @PutMapping("/logoffPorteiro/{email}")
    public ResponseEntity logoffPorteiro(@PathVariable String email){
        Porteiro porteiro1 = porteiroRepository.findByEmail(email);
        if (porteiro1 != null){
            if (porteiro1.getAutenticado()){
                porteiro1.setAutenticado(false);
                porteiroRepository.save(porteiro1);
                return ResponseEntity.status(200).body("Porteiro deslogado com sucesso!");
            }else {
                return ResponseEntity.status(400).body("Porteiro não está logado!");
            }
        }
        return ResponseEntity.status(400).body("Porteiro não encontrado!");
    }

    @DeleteMapping("/excluirMorador/{email}")
    public ResponseEntity deleteMorador(@PathVariable String email)
    {
        for(Morador usuario : moradorRepository.findAll())
        {
            if(email.equals(usuario.getEmail()))
            {
               moradorRepository.deleteById(usuario.getId());
               return ResponseEntity.status(200).body("Morador " + usuario.getNome() + " excluído com sucesso");
            }
        }
              return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/excluirPorteiro/{email}")
    public ResponseEntity deletePorteiro(@PathVariable String email)
    {
        for(Porteiro usuario : porteiroRepository.findAll())
        {
            if(email.equals(usuario.getEmail()))
            {
                porteiroRepository.deleteById(usuario.getId());
                return ResponseEntity.status(200).body("Porteiro " + usuario.getNome() + " excluído com sucesso");
            }
        }
                return ResponseEntity.status(404).build();
    }

    @PostMapping("/loginMorador/{email}/{senha}")
    public ResponseEntity<Object> loginMorador(@PathVariable String email, @PathVariable String senha){
        Morador usuario = moradorRepository.findByEmail(email);

        if (usuario != null) {
            if (usuario.senha().equals(senha)) {
                usuario.setAutenticado(true);
                moradorRepository.save(usuario);
                return ResponseEntity.status(200).body("Login realizado com sucesso!");
            }else {
                return ResponseEntity.status(401).body("Usuário ou senha incorretos!");
            }
        }
        return ResponseEntity.status(404).body("Usuário não encontrado");
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUsuario(@RequestBody Morador morador){
        Morador usuario = moradorRepository.findByEmail(morador.getEmail());
        if (usuario != null) {
            if (usuario.senha().equals(morador.senha())) {
                usuario.setAutenticado(true);
                moradorRepository.save(usuario);
                return ResponseEntity.status(200).body("Login realizado com sucesso!");
            }else {
                return ResponseEntity.status(401).body("Usuário e/ou senha incorretos!");
            }
        }
        return ResponseEntity.status(404).body("Usuário não encontrado");
    }

    @PostMapping("/loginPorteiro/{email}/{senha}")
    public ResponseEntity<Object> loginPorteiro(@PathVariable String email, @PathVariable String senha) {
        Porteiro usuario = porteiroRepository.findByEmail(email);
        if (usuario != null) {
            if (usuario.senha().equals(senha)) {
                usuario.setAutenticado(true);
                porteiroRepository.save(usuario);
                return ResponseEntity.status(200).body("Login realizado com sucesso!");
            }else {
                return ResponseEntity.status(401).body("Usuário ou senha incorretos!");
            }
        }
        return ResponseEntity.status(404).body("Usuário não encontrado");
    }
}
