package meed.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import meed.voll.api.direction.Direction;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direction direccion;

    public Medico(MedicDataReg medicDataReg) {
        this.activo = true;
        this.nombre = medicDataReg.nombre();
        this.email = medicDataReg.email();
        this.telefono = medicDataReg.telefono();
        this.documento = medicDataReg.documento();
        this.especialidad = medicDataReg.especialidad();
        this.direccion = new Direction(medicDataReg.direccion());
    }

    public void actualizarDatos(MedicActData medicActData) {
        if (medicActData.nombre() != null) {
            this.nombre = medicActData.nombre();
        }
        if (medicActData.documento() != null) {
            this.documento = medicActData.documento();
        }
        if (medicActData.direccion() != null) {
            this.direccion = direccion.actualizarDatos(medicActData.direccion());
        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
