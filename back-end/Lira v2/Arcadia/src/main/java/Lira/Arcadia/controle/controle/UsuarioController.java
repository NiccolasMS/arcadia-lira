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

import java.util.List;

@RestController
@RequestMapping("/usuario")
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
    public ResponseEntity logoffMorador(@PathVariable String email, @RequestBody Morador morador){
        for (Morador usuario1 : moradorRepository.findAll()){
            if (email.equals(usuario1.getEmail()) && usuario1.getAutenticado().equals(true)){
                usuario1.setAutenticado(false);
                moradorRepository.save(morador);

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

    @PutMapping("/logoffPorteiro/{email}")
    public ResponseEntity logoffPorteiro(@PathVariable String email, @RequestBody Porteiro porteiro){
        for (Usuario usuario1 : porteiroRepository.findAll()){
            if (email.equals(usuario1.getEmail()) && usuario1.getAutenticado().equals(true)){
                usuario1.setAutenticado(false);
                porteiroRepository.save(porteiro);
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

    @DeleteMapping("/excluirMorador/{email}")
    public ResponseEntity deleteMorador(@PathVariable String email)
    {
        for(Morador usuario : moradorRepository.findAll())
        {
            if(email.equals(usuario.getEmail()))
            {
               moradorRepository.deleteById(usuario.getId());
               return ResponseEntity.status(200).build();
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
                return ResponseEntity.status(200).build();
            }
        }
                return ResponseEntity.status(404).build();
    }

    @PostMapping("/cadastrarEncomenda/{nomeMorador}")
    public ResponseEntity postEncomenda(@PathVariable String nomeMorador,
                                        @RequestBody Encomenda newEncomenda)
    {
        for (Encomenda encomenda : encomendaRepository.findAll()){
            if (encomenda.getCodigoDeRastreio().equals(newEncomenda.getCodigoDeRastreio())){
                return ResponseEntity.status(400).body("Encomenda já cadastrada com esse código");
            }
        }
        newEncomenda.setNomeMorador(nomeMorador);
        encomendaRepository.save(newEncomenda);
        //201 CREATED, geralmente utilizada com post
        return ResponseEntity.status(201).body("Encomenda cadastrada com sucesso!\n"  + newEncomenda);
    }
    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Morador morador, @RequestBody Porteiro porteiro) {
        for (Morador usuario : moradorRepository.findAll()) {
            if (usuario.getEmail().equals(morador.getEmail()) && usuario.getSenha().equals(morador.getSenha())) {
                usuario.setAutenticado(true);
                moradorRepository.save(morador);
                return ResponseEntity.status(200).body("Login do usuário " + usuario.getNome() + " concluído");
            }
        }
        for (Porteiro usuario : porteiroRepository.findAll()) {
            if (usuario.getEmail().equals(porteiro.getEmail()) && usuario.getSenha().equals(porteiro.getSenha())) {
                usuario.setAutenticado(true);
                porteiroRepository.save(porteiro);
                return ResponseEntity.status(200).body("Login do usuário " + usuario.getNome() + " concluído");
            }
        }
        return ResponseEntity.status(404).body("Usuário não encontrado");
    }
}
