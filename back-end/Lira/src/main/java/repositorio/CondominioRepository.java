package repositorio;

import dominio.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondominioRepository extends JpaRepository<Condominio, Integer> {
}
