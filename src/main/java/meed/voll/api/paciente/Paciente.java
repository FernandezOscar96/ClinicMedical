package meed.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import meed.voll.api.direction.Direction;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Embedded
    private Direction direccion;

    public Paciente(PacientDataReg PacienteData) {
        this.nombre = PacienteData.nombre();
        this.email = PacienteData.email();
        this.telefono = PacienteData.telefono();
        this.documento = PacienteData.documento();
        this.direccion = new Direction(PacienteData.direccion());
    }
}
