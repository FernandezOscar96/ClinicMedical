package meed.voll.api.paciente;

import meed.voll.api.domain.direction.DirectionData;

public record RequestPacientData(Long id,
                                 String nombre,
                                 String email,
                                 String telefono,
                                 String documento,
                                 DirectionData direccion) {
}
