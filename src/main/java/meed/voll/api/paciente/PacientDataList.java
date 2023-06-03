package meed.voll.api.paciente;

public record PacientDataList(String nombre, String email, String documento) {
    public PacientDataList(Paciente paciente) {
        this(paciente.getNombre(), paciente.getEmail(), paciente.getDocumento());
    }
}