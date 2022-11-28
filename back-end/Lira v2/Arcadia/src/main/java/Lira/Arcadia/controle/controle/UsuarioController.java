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
            if(newUsuario.getNome() == "" || newUsuario.getNome() == null)
            {
                return ResponseEntity.status(400).body("Campo nome não pode ficar vazio");
            } else if (newUsuario.getNome().length() < 3) {
                return ResponseEntity.status(400).body("Campo nome deve ter mais 3 de caracteres");
            }

            Boolean hotmail = newUsuario.getEmail().contains("@hotmail.com");
            Boolean gmail = newUsuario.getEmail().contains("@outlook.com");
            if(!hotmail && !gmail)
            {
                return ResponseEntity.status(400).body("Domínios válidos @hotmail.com ou @outlook.com");
            }

            if(newUsuario.getTelefone().length() < 15)
            {
                return ResponseEntity.status(400).body("Telefone deve seguir o padrão (11) 12345-6789");
            }

            if(newUsuario.senha().equals("")|| newUsuario.senha() == null)
            {
                return ResponseEntity.status(400).body("Preencha o campo senha");
            }

            if(newUsuario.getBloco() == "" || newUsuario.getBloco() == null)
            {
                return ResponseEntity.status(400).body("Preencha o campo bloco");
            }


        if (newUsuario.senha().length() < 3) {
            return ResponseEntity.status(400).body("Campo senha deve ter no mínimo 3 caracteres");
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

            if(newUsuario.getNome() == "" || newUsuario.getNome() == null)
            {
                    return ResponseEntity.status(400).body("Campo nome não pode ficar vazio");
            } else if (newUsuario.getNome().length() < 3) {
                    return ResponseEntity.status(400).body("Campo nome deve ter no mínimo 3 caracteres");
            }

            Boolean hotmail = newUsuario.getEmail().contains("@hotmail.com");
            Boolean gmail = newUsuario.getEmail().contains("@outlook.com");
            if(!hotmail && !gmail)
            {
                return ResponseEntity.status(400).body("Domínios válidos @hotmail.com ou @outlook.com");
            }

            if(newUsuario.getTelefone().length() < 15)
            {
                return ResponseEntity.status(400).body("Telefone deve seguir o padrão (11) 12345-6789");
            }

        if(newUsuario.senha().equals("")|| newUsuario.senha() == null)
        {
            return ResponseEntity.status(400).body("Preencha o campo senha");
        }

        if (newUsuario.senha().length() < 3) {
            return ResponseEntity.status(400).body("Campo senha deve ter no mínimo 3 caracteres");
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

    @GetMapping("/loginMorador")
    public ResponseEntity<Object> login(@RequestBody Morador morador){
        Morador usuario = moradorRepository.findByEmail(morador.getEmail());
        if (usuario != null) {
            if (usuario.senha().equals(morador.senha())) {
                usuario.setAutenticado(true);
                moradorRepository.save(usuario);
                return ResponseEntity.status(200).body("Login realizado com sucesso!");
            }else {
                return ResponseEntity.status(401).body("Usuário ou senha incorretos!");
            }
        }
        return ResponseEntity.status(404).body("Usuário não encontrado");
    }
    @GetMapping("/loginPorteiro")
    public ResponseEntity<Object> login(@RequestBody Porteiro porteiro) {
        Porteiro usuario = porteiroRepository.findByEmail(porteiro.getEmail());
        if (usuario != null) {
            if (usuario.senha().equals(porteiro.senha())) {
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
