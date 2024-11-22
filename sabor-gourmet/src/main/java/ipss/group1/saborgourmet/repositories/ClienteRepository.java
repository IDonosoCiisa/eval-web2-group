package ipss.group1.saborgourmet.repositories;

import ipss.group1.saborgourmet.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
