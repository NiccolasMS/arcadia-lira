package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Encomenda;
import Lira.Arcadia.controle.repositorio.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/encomendas")
public class EncomendaController {

    @Autowired
    private EncomendaRepository repository;

    private List<Encomenda> encomendas = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Object> cadastrarEncomenda(@RequestBody Encomenda encomenda){
        if (repository.findAll().contains(encomenda)){
            return ResponseEntity.status(400).body("Encomenda já cadastrada!");
        }
        encomenda.setTopo();
        encomenda.push("Entregue");
        encomenda.push("Chegando");
        encomenda.push("Transportando");
        encomenda.push("Empacotando");
        encomenda.setStatus();

        encomendas.add(encomenda);
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

    @PutMapping("/atualizar-status/{id}")
    public ResponseEntity atualizarStatus(@PathVariable int id)
    {
       Encomenda encomenda = repository.findById(id);
       Encomenda encomenda2 = null;

       for(Encomenda e : encomendas)
       {
           if(e.getId() == id)
           {
               encomenda2 = e;
           }
       }


       if(encomenda != null)
       {

           if(encomenda2.pop() != null){
               encomenda2.setStatus();

               repository.save(encomenda2);

               return ResponseEntity.status(200).body("Status atualizado para " + encomenda.getStatus());
           }
                //405 Method Not Allowed O método de solicitação é conhecido pelo servidor,
                 // mas foi desativado e não pode ser usado.
                return  ResponseEntity.status(405).build();
       }

        return ResponseEntity.status(404).body("Encomenda não encontrada!");
    }

    @GetMapping("/pilha/{id}")
            public String[] pilha(@PathVariable int id)
    {
        Encomenda encomenda2 = null;

        for(Encomenda e : encomendas)
        {
            if(e.getId() == id)
            {
                encomenda2 = e;
            }
        }

       return encomenda2.pilha();
    }

    @GetMapping("/topo/{id}")
    public int topo(@PathVariable int id)
    {
        Encomenda encomenda2 = null;

        for(Encomenda e : encomendas)
        {
            if(e.getId() == id)
            {
                encomenda2 = e;
            }
        }

        return encomenda2.getTopo();
    }
}
