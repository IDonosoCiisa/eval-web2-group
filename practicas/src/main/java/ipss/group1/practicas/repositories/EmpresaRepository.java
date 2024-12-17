package ipss.group1.practicas.repositories;

import ipss.group1.practicas.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository  extends JpaRepository<Empresa, Long> {
}
