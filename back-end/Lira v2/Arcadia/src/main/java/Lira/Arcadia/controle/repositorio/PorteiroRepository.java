package Lira.Arcadia.controle.repositorio;

import Lira.Arcadia.controle.dominio.Porteiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PorteiroRepository extends JpaRepository<Porteiro, Integer> {
    Porteiro findByEmail(String email);
}
