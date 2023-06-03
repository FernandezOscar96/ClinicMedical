package meed.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import meed.voll.api.direction.DirectionData;

public record MedicActData(
        @NotNull Long id,
        String nombre,
        String documento,
        DirectionData direccion) {
}
