package Lira.Arcadia.controle.repositorio;

import Lira.Arcadia.controle.dominio.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Integer> {
    Morador findByEmail(String email);
    Morador findByNome(String nome);
}
