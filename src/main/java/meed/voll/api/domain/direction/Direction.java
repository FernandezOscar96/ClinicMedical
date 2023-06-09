package meed.voll.api.domain.direction;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direction {

    private String calle;
    private String numero;
    private String complemento;
    private String ciudad;
    private String distrito;

    public Direction(DirectionData direccion) {
        this.calle = direccion.calle();
        this.ciudad = direccion.ciudad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
        this.distrito = direccion.distrito();
    }

    public Direction actualizarDatos(DirectionData direccion) {
        this.calle = direccion.calle();
        this.ciudad = direccion.ciudad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
        this.distrito = direccion.distrito();
        return this;
    }
}
