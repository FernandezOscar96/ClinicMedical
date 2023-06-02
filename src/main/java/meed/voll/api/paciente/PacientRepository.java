package meed.voll.api.paciente;

import meed.voll.api.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository<Paciente, Long> {
}
