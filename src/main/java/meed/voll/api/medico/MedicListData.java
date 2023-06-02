package meed.voll.api.medico;

public record MedicListData(String nombre,
                            String especialidad,
                            String documento,
                            String email) {
    public MedicListData(Medico medico) {
        this(   medico.getNombre(),
                medico.getEspecialidad().toString(),
                medico.getDocumento(),
                medico.getEmail()
        );
    }
}
