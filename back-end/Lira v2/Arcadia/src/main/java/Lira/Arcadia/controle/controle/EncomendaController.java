package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Encomenda;
import Lira.Arcadia.controle.repositorio.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encomendas")
public class EncomendaController {
    @Autowired
    private EncomendaRepository repository;

    @PostMapping
    public ResponseEntity<Object> cadastrarEncomenda(@RequestBody Encomenda encomenda){
        if (repository.findAll().contains(encomenda)){
            return ResponseEntity.status(400).body("Encomenda já cadastrada!");
        }
        repository.save(encomenda);
        return ResponseEntity.status(201).body("Encomenda cadastrada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<Object> getEncomendas(){
        if (repository.findAll().isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PutMapping("/atualizarCodigoRastreio/{codigoRastreio}/{novoCodigoRastreio}")
    public ResponseEntity<Object> atualizaCodigoRastreio(@PathVariable String codigoRastreio, @PathVariable String novoCodigoRastreio){
        Encomenda encomenda1 = repository.findByCodigoDeRastreio(codigoRastreio);
        if (encomenda1 != null){
            encomenda1.setCodigoDeRastreio(novoCodigoRastreio);
            repository.save(encomenda1);
            return ResponseEntity.status(200).body("Código de rastreio atualizado com sucesso!");
        }
        return ResponseEntity.status(404).body("Encomenda não encontrada!");
    }


    @DeleteMapping("/deletarEncomenda/{id}")
    public ResponseEntity<Object> deletarEncomenda(@PathVariable int id){
        for (Encomenda encomenda : repository.findAll()){
            if (encomenda.getId() == id){
                repository.delete(encomenda);
                return ResponseEntity.status(200).body("Encomenda deletada com sucesso!");
            }
        }
        return ResponseEntity.status(404).body("Encomenda não encontrada!");
    }
}
