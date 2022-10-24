package Lira.Arcadia.controle.repositorio;

import Lira.Arcadia.controle.dominio.Encomenda;
import Lira.Arcadia.controle.dominio.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncomendaRepository extends JpaRepository<Encomenda,Integer> {
    Encomenda findByCodigoDeRastreio(String codigoDeRastreio);
}
