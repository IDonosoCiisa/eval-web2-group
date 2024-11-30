package ipss.group1.saborgourmet.repositories;

import ipss.group1.saborgourmet.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
// Repositorio para la entidad Cliente, extiende de JpaRepository para tener acceso a las operaciones CRUD.
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
