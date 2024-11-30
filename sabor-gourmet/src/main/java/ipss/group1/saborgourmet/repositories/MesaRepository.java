package ipss.group1.saborgourmet.repositories;

import ipss.group1.saborgourmet.models.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
// Repositorio para la entidad Mesa, extiende de JpaRepository para tener acceso a las operaciones CRUD.
public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
