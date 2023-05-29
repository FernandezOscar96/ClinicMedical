package meed.voll.api.medico;


import meed.voll.api.direction.DirectionData;

public record MedicDataReg(String nombre, String email, String documento, Especialidad especialidad,
                           DirectionData direccion) {


}
