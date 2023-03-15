package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Controle;
import Lira.Arcadia.controle.repositorio.ControleRepository;
import Lira.Arcadia.controle.repositorio.EncomendaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/controle")
public class ControleController {
    private ControleRepository repository;
    private EncomendaRepository encomendaRepository;

    @GetMapping("/listarEncomendas")
    public ResponseEntity<Object> listarEncomendas(){
        return ResponseEntity.status(200).body(encomendaRepository.findAll());
    }
}
