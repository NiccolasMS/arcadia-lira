package Lira.Arcadia.controle.repositorio;

import Lira.Arcadia.controle.dominio.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncomendaRepository extends JpaRepository<Encomenda,Integer> {
}
