package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Encomenda;
import Lira.Arcadia.controle.repositorio.EncomendaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encomendas")
public class EncomendaController {
    private EncomendaRepository repository;

    @PostMapping
    public ResponseEntity<Object> cadastrarEncomenda(@RequestBody Encomenda encomenda){
        if (repository.findAll().contains(encomenda)){
            return ResponseEntity.status(400).body("Encomenda já cadastrada!");
        }
        repository.save(encomenda);
        return ResponseEntity.status(201).body("Encomenda cadastrada com sucesso!");
    }
}
