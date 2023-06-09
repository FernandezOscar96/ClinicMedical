package meed.voll.api.domain.medico;

import meed.voll.api.domain.direction.DirectionData;

public record RequestMedicData(Long id,
                               String nombre,
                               String email,
                               String telefono,
                               String documento,
                               DirectionData direccion) {
}
