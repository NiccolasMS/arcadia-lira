package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Encomenda;
import Lira.Arcadia.controle.dominio.Morador;
import Lira.Arcadia.controle.dominio.Usuario;
import Lira.Arcadia.controle.repositorio.EncomendaRepository;
import Lira.Arcadia.controle.repositorio.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/morador")
public class MoradorController {
    @Autowired
    private MoradorRepository moradorRepository;
    @Autowired
    private EncomendaRepository encomendaRepository;

    @PutMapping("/autenticacaoMorador/{email}/{senha}")
    public ResponseEntity<Usuario> autenticarMorador(@PathVariable String email,
                                                     @PathVariable String senha,
                                                     @RequestBody Morador morador){
        for (Usuario usuario1 : moradorRepository.findAll()){
            if (email.equals(usuario1.getEmail()) && senha.equals(usuario1.getSenha())){
                usuario1.setAutenticado(true);
                moradorRepository.save(morador);
                return ResponseEntity.status(200).body(usuario1);
            }
        }
        //401 não autorizado
        return ResponseEntity.status(401).build();
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

}
