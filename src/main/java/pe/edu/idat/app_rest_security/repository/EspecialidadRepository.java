package pe.edu.idat.app_rest_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.app_rest_security.model.Especialidad;

public interface EspecialidadRepository extends
        JpaRepository<Especialidad, Integer> {
}
