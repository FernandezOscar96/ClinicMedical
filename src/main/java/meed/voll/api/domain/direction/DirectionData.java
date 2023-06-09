package meed.voll.api.domain.direction;

import jakarta.validation.constraints.NotBlank;

public record DirectionData(@NotBlank
                            String calle,
                            @NotBlank
                            String distrito,
                            @NotBlank
                            String ciudad,
                            @NotBlank
                            String numero,
                            @NotBlank
                            String complemento) {
}
