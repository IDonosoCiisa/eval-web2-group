package ipss.group1.practicas.repositories;

import ipss.group1.practicas.models.Jefe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JefeRepository extends JpaRepository<Jefe, Long> {
}
