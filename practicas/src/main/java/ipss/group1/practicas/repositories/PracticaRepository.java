package ipss.group1.practicas.repositories;

import ipss.group1.practicas.models.Practica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticaRepository extends JpaRepository<Practica, Long> {
}
