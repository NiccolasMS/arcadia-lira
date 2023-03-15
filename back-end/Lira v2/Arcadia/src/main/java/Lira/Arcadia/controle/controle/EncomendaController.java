package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Encomenda;
import Lira.Arcadia.controle.dominio.Morador;
import Lira.Arcadia.controle.repositorio.EncomendaRepository;
import Lira.Arcadia.controle.repositorio.MoradorRepository;
import Lira.Arcadia.controle.utils.Fila;
import Lira.Arcadia.controle.utils.GerarCsv;
import Lira.Arcadia.controle.utils.GerarTxt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/encomendas")
public class EncomendaController {

    Fila fila = new Fila(100);
    @Autowired
    private EncomendaRepository repository;

    @Autowired
    private MoradorRepository moradorRepository;

    private List<Encomenda> encomendas = new ArrayList<>();

    @PostMapping("/cadastrarEncomenda/{codRastreio}/{desc}")
    public ResponseEntity<Object> cadastrarEncomenda2(@PathVariable String codRastreio, @PathVariable String desc){
        if (repository.findAll().contains(codRastreio)){
            return ResponseEntity.status(400).body("Encomenda já cadastrada!");
        }
        Encomenda encomenda = new Encomenda(codRastreio,desc);
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
    @PostMapping
    public ResponseEntity<Object> cadastrarEncomenda(@RequestBody Encomenda encomenda){
        if (repository.findAll().contains(encomenda)){
            return ResponseEntity.status(400).body("Encomenda já cadastrada!");
        }

        if(encomenda.getCodigoDeRastreio().equals("") || encomenda.getCodigoDeRastreio() == null )
        {
            return ResponseEntity.status(400).body("Preencha o campo código de rastreio");
        } else if (encomenda.getCodigoDeRastreio().length() <= 4) {
            return ResponseEntity.status(400).body("Código de rastreio deve ter mais de 4 caracteres");
        } else if (encomenda.getCodigoDeRastreio().length() >= 16) {
            return ResponseEntity.status(400).body("Código de rastreio deve ter no máximo 15 caracteres");
        }

        encomenda.setTopo();
        encomenda.push("Entregue");
        encomenda.push("Chegando");
        encomenda.push("Transportando");
        encomenda.push("Empacotando");
        encomenda.setStatus();

        encomendas.add(encomenda);
        fila.insert(encomenda);
        
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

    @GetMapping(value = "/gerarCsv/{id}", produces = "text/csv")
    public ResponseEntity<byte[]> gerarCsv (@PathVariable int id) throws IOException {
        for (Morador morador : moradorRepository.findAll()){
            if (morador.getId() == id){
                List<Encomenda> encomendas = repository.findAll();
                GerarCsv.gerarCsvEncomenda(encomendas, "encomendas.csv");
                File file = new File("encomendas.csv");
                byte[] bytes = Files.readAllBytes(file.toPath());
                return ResponseEntity.status(200).header("content-disposition", "attachment; filename=\"encomendas.csv\"").body(bytes);
            }
        }
        return ResponseEntity.status(404).build();
    }
    @GetMapping(value = "/gerarTxt/{id}", produces = "text/txt")
    public ResponseEntity<byte[]> gerarTxt (@PathVariable int id) throws IOException {
        for (Morador morador : moradorRepository.findAll()){
            if (morador.getId() == id){
                List<Encomenda> encomendas = repository.findAll();
                GerarTxt.gravaArquivoTxt(encomendas, "encomendas.txt");
                File file = new File("encomendas.txt");
                byte[] bytes = Files.readAllBytes(file.toPath());
                return ResponseEntity.status(200).header("content-disposition", "attachment; filename=\"encomendas.txt\"").body(bytes);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/data-chegada/{id}")
    public ResponseEntity putDataChegada(@PathVariable int id)
    {

        Encomenda encomenda = repository.findById(id);

        if(encomenda != null)
        {
            encomenda.setDataChegada();
            fila.insert(encomenda);
            return ResponseEntity.status(200).body(repository.save(encomenda));
        }

            return ResponseEntity.status(404).body("Encomenda não encontrada!");
    }

    @GetMapping("/lista-prioridade")
    public ResponseEntity<List<Encomenda>> getListaPrioridade()
    {
        if(fila.exibe().isEmpty())
        {
          return   ResponseEntity.status(204).build();
        }
          return ResponseEntity.status(200).body(fila.exibe());
    }

    @GetMapping("/prioridade")
    public ResponseEntity<Encomenda> getPrioridade()
    {
        if(fila.peek() == null)
        {
            return ResponseEntity.status(204).build();
        }

            return ResponseEntity.status(200).body(fila.peek());
    }

    @DeleteMapping("/deletar-prioridade")
    public ResponseEntity<Encomenda> deletePrioridade()
    {
        if(fila.peek() == null)
        {
            return ResponseEntity.status(204).build();
        }

            return ResponseEntity.status(200).body(fila.poll());
    }


}
