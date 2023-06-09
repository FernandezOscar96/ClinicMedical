package meed.voll.api.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findByActivoTrue(Pageable paginacion);
}
