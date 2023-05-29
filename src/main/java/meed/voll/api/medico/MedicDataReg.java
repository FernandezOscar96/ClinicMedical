package meed.voll.api.medico;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import meed.voll.api.direction.DirectionData;

public record MedicDataReg(@NotBlank
                           String nombre,
                           @NotNull
                           @Email
                           String email,
                           @NotBlank
                           @Pattern(regexp = "\\d{4,6}")
                           String documento,
                           @NotNull
                           Especialidad especialidad,
                           @NotNull
                           @Valid
                           DirectionData direccion) {


}
