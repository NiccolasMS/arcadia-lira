package controle;

import dominio.Condominio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositorio.CondominioRepository;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/condominio")
public class CondominioController {

    @Autowired
    private CondominioRepository repository;

    @PostMapping("/cadastrarCondominio")
    public ResponseEntity postCondominio(@RequestBody Condominio newCondominio){

        for (Condominio condominio1 : repository.findAll()){
            if (condominio1.getNome().equals(newCondominio.getNome())){
                return ResponseEntity.status(400).body("Condomínio já cadastrado com esse nome!");
            }
        }
        repository.save(newCondominio);
        //201 CREATED, geralmente utilizada com post
        return ResponseEntity.status(201).body("Condomínio cadastrado com sucesso!\n"  + newCondominio);
    }

    @GetMapping
    public ResponseEntity<List<Condominio>> getCondominios() {
        List<Condominio> lista = repository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
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
    public ResponseEntity deleteCarro(@PathVariable String nome) {
        Condominio condominio = getCondominio(nome).getBody();

        if (condominio != ResponseEntity.status(404)) {
            repository.deleteById(condominio.getId());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
