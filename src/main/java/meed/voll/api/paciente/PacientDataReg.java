package meed.voll.api.paciente;

import meed.voll.api.direction.DirectionData;

public record PacientDataReg(String nombre,
                             String email,
                             String telefono,
                             String documento,
                             DirectionData direccion) {
}
