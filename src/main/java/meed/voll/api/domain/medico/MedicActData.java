package meed.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import meed.voll.api.domain.direction.DirectionData;

public record MedicActData(
        @NotNull Long id,
        String nombre,
        String documento,
        DirectionData direccion) {
}
