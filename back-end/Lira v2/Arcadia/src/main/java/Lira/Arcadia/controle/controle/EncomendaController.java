package Lira.Arcadia.controle.controle;

import Lira.Arcadia.controle.dominio.Encomenda;
import Lira.Arcadia.controle.dominio.Taxa;
import Lira.Arcadia.controle.repositorio.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/implementarTaxa")
public class EncomendaController implements Taxa {

    @Autowired
    private EncomendaRepository repository;

    @Override
    public Double implementarTaxa(Encomenda encomenda) {
        if(encomenda.getDiasEmEspera() > 15)
        {
            encomenda.setTaxa(100.50);
            repository.save(encomenda);
        }
        return encomenda.getTaxa();
    }

}
