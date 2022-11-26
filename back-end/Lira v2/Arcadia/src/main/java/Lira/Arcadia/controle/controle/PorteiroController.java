package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Porteiro;
import Lira.Arcadia.controle.dominio.Usuario;
import Lira.Arcadia.controle.repositorio.PorteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/porteiros")
public class PorteiroController {
    @Autowired
    private PorteiroRepository porteiroRepository;

    @PutMapping("/autenticacaoPorteiro/{email}/{senha}")
    public ResponseEntity<Usuario> autenticarPorteiro(@PathVariable String email,
                                                      @PathVariable String senha,
                                                      @RequestBody Porteiro porteiro){
        for (Usuario usuario1 : porteiroRepository.findAll()){
            if (email.equals(usuario1.getEmail()) && senha.equals(usuario1.senha())){
                usuario1.setAutenticado(true);
                porteiroRepository.save(porteiro);
                return ResponseEntity.status(200).body(usuario1);
            }
        }
        //401 não autorizado
        return ResponseEntity.status(401).build();
    }

}
