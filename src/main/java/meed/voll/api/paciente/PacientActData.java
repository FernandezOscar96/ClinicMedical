package meed.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import meed.voll.api.domain.direction.DirectionData;

public record PacientActData(@NotNull Long id,
                             String nombre,
                             String documento,
                             DirectionData direccion) {
}
