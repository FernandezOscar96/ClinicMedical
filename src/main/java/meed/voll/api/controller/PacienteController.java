package meed.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import meed.voll.api.medico.MedicActData;
import meed.voll.api.medico.MedicListData;
import meed.voll.api.medico.Medico;
import meed.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacientRepository pacientRepository;
    @PostMapping
    public void registrar(@RequestBody @Valid PacientDataReg PacientDataReg){
        pacientRepository.save(new Paciente(PacientDataReg));
    }

    @GetMapping
    public Page<PacientDataList> listar(@PageableDefault(page=0,size=10,sort={"nombre"})Pageable paginacion){
        //return pacientRepository.findAll(paginacion).map(PacientDataList::new);
        return pacientRepository.findByActivoTrue(paginacion).map(PacientDataList::new);
    }

    @PutMapping
    @Transactional
    public void actualizarPaciente(@RequestBody @Valid PacientActData pacientActData) {
        Paciente paciente = pacientRepository.getReferenceById(pacientActData.id());
        paciente.actualizarDatos(pacientActData);
    }
    @DeleteMapping("/eliminarPaciente/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id) {
        Paciente paciente = pacientRepository.getReferenceById(id);
        paciente.desactivarPaciente();

    }
}
