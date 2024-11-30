package ipss.group1.saborgourmet.repositories;

import ipss.group1.saborgourmet.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
// Repositorio para la entidad Reserva, extiende de JpaRepository para tener acceso a las operaciones CRUD.
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
