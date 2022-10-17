package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Condominio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Lira.Arcadia.controle.repositorio.CondominioRepository;

import java.util.List;

@RestController
@RequestMapping("/condominio")
public class CondominioController {
    ListaObjCondominio lista = new ListaObjCondominio(10);
    @Autowired
    private CondominioRepository repository;

    @PostMapping("/cadastrarCondominio")
    public ResponseEntity postCondominio(@RequestBody Condominio newCondominio){


        for (Condominio condominio1 : repository.findAll()){
            if (condominio1.getNome().equals(newCondominio.getNome())){
                return ResponseEntity.status(400).body("Condomínio já cadastrado com esse nome!");
            }
        }
        lista.adiciona(newCondominio);
        repository.save(newCondominio);
        //201 CREATED, geralmente utilizada com post
        return ResponseEntity.status(200).body("Condomínio cadastrado com sucesso!\n"  + newCondominio);
    }

    @GetMapping
    public ResponseEntity<Condominio[]> getCondominios() {
        //List<Condominio> lista = repository.findAll();
        //return lista.isEmpty()
         //       ? ResponseEntity.status(204).build()
         //       : ResponseEntity.status(200).body(lista);

        return ResponseEntity.status(200).body(lista.getElementos());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Condominio> getCondominio(@PathVariable String nome) {
        for(Condominio condominio : repository.findAll())
        {
            if(condominio.getNome().equals(nome)){
                return ResponseEntity.status(200).body(condominio);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity deleteCondominio(@PathVariable String nome) {
        Condominio condominio = getCondominio(nome).getBody();

        if (getCondominio(nome).hasBody() != false) {


            repository.deleteById(condominio.getId());

            lista.removePeloIndice(condominio.getId());

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

//    @DeleteMapping("/deletarCondominio/{id}")
//    public ResponseEntity<Object> deleteCondominio(@PathVariable int id) {
//        Condominio condominio = repository.findById(id);
//        if (condominio != null) {
//            repository.deleteById(condominio.getId());
//            lista.removePeloIndice(condominio.getId());
//            return ResponseEntity.status(200).body("Condomínio deletado com sucesso!");
//        }
//
//        return ResponseEntity.status(404).body("Condomínio não encontrado!");
//    }

}
