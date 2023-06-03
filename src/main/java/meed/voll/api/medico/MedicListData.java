package meed.voll.api.medico;

public record MedicListData(Long id, String nombre,
                            String especialidad,
                            String documento,
                            String email) {
    public MedicListData(Medico medico) {
        this(   medico.getId(),
                medico.getNombre(),
                medico.getEspecialidad().toString(),
                medico.getDocumento(),
                medico.getEmail()
        );
    }
}
