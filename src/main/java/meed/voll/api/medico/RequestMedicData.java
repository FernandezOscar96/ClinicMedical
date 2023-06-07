package meed.voll.api.medico;

import meed.voll.api.direction.DirectionData;

public record RequestMedicData(Long id,
                               String nombre,
                               String email,
                               String telefono,
                               String documento,
                               DirectionData direccion) {
}
