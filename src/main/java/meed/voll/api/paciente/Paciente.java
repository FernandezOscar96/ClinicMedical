package meed.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import meed.voll.api.domain.direction.Direction;

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
    private boolean activo;
    @Embedded
    private Direction direccion;

    public Paciente(PacientDataReg PacienteData) {
        this.activo = true;
        this.nombre = PacienteData.nombre();
        this.email = PacienteData.email();
        this.telefono = PacienteData.telefono();
        this.documento = PacienteData.documento();
        this.direccion = new Direction(PacienteData.direccion());
    }

    public void actualizarDatos(PacientActData pacientActData) {
        if (pacientActData.nombre() != null) {
            this.nombre = pacientActData.nombre();
        }
        if (pacientActData.documento() != null) {
            this.documento = pacientActData.documento();
        }
        if (pacientActData.direccion() != null) {
            this.direccion = direccion.actualizarDatos(pacientActData.direccion());
        }
    }


    public void desactivarPaciente() {
        this.activo = false;
    }
}
