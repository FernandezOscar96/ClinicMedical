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
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direction direccion;

    public Medico(MedicDataReg medicDataReg) {
        this.nombre = medicDataReg.nombre();
        this.email = medicDataReg.email();
        this.documento = medicDataReg.documento();
        this.especialidad = medicDataReg.especialidad();
        this.direccion = new Direction(medicDataReg.direccion());
    }
}
