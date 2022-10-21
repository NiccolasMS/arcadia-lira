package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Encomenda;
import Lira.Arcadia.controle.dominio.Morador;
import Lira.Arcadia.controle.dominio.Usuario;
import Lira.Arcadia.controle.repositorio.EncomendaRepository;
import Lira.Arcadia.controle.repositorio.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moradores")
public class MoradorController {
    @Autowired
    private MoradorRepository moradorRepository;



    @PutMapping("/autenticacaoMorador/{email}/{senha}")
    public ResponseEntity<Usuario> autenticarMorador(@PathVariable String email,
                                                     @PathVariable String senha,
                                                     @RequestBody Morador morador){
        for (Usuario usuario1 : moradorRepository.findAll()){
            if (email.equals(usuario1.getEmail()) && senha.equals(usuario1.senha())){
                usuario1.setAutenticado(true);
                moradorRepository.save(morador);
                return ResponseEntity.status(200).body(usuario1);
            }
        }
        //401 não autorizado
        return ResponseEntity.status(401).build();
    }

}
