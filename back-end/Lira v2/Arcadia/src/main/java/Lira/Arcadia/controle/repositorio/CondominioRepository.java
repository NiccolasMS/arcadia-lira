package Lira.Arcadia.controle.repositorio;

import Lira.Arcadia.controle.dominio.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominioRepository extends JpaRepository<Condominio, Integer> {
}
