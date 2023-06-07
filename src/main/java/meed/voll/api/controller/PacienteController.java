package meed.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import meed.voll.api.direction.DirectionData;
import meed.voll.api.medico.MedicActData;
import meed.voll.api.medico.MedicListData;
import meed.voll.api.medico.Medico;
import meed.voll.api.medico.RequestMedicData;
import meed.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacientRepository pacientRepository;
    @PostMapping
    public ResponseEntity<RequestPacientData> registrar(@RequestBody @Valid PacientDataReg PacientDataReg, UriComponentsBuilder uriComponentsBuilder){
        Paciente paciente = pacientRepository.save(new Paciente(PacientDataReg));
        RequestPacientData requestPacientData = new RequestPacientData(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                paciente.getDocumento(),
                new DirectionData(
                        paciente.getDireccion().getCalle(),
                        paciente.getDireccion().getDistrito(),
                        paciente.getDireccion().getCiudad(),
                        paciente.getDireccion().getNumero(),
                        paciente.getDireccion().getComplemento()));
        URI url = uriComponentsBuilder.path("/paciente/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(url).body(requestPacientData);
    }

    @GetMapping
    public ResponseEntity<Page<PacientDataList>> listar(@PageableDefault(page=0,size=10,sort={"nombre"})Pageable paginacion){
        //return pacientRepository.findAll(paginacion).map(PacientDataList::new);
        return ResponseEntity.ok(pacientRepository.findByActivoTrue(paginacion).map(PacientDataList::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<RequestPacientData> actualizarPaciente(@RequestBody @Valid PacientActData pacientActData) {
        Paciente paciente = pacientRepository.getReferenceById(pacientActData.id());
        paciente.actualizarDatos(pacientActData);
        return ResponseEntity.ok(new RequestPacientData(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                paciente.getDocumento(),
                new DirectionData(
                        paciente.getDireccion().getCalle(),
                        paciente.getDireccion().getDistrito(),
                        paciente.getDireccion().getCiudad(),
                        paciente.getDireccion().getNumero(),
                        paciente.getDireccion().getComplemento())));
    }
    @DeleteMapping("/eliminarPaciente/{id}")
    @Transactional
    public ResponseEntity<RequestPacientData> eliminarPaciente(@PathVariable Long id) {
        Paciente paciente = pacientRepository.getReferenceById(id);
        paciente.desactivarPaciente();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/eliminarPaciente/{id}")
    @Transactional
    public ResponseEntity<RequestPacientData> returnPacientData(@PathVariable Long id) {
        Paciente paciente = pacientRepository.getReferenceById(id);
        var datosPaciente = new RequestPacientData(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                paciente.getDocumento(),
                new DirectionData(
                        paciente.getDireccion().getCalle(),
                        paciente.getDireccion().getDistrito(),
                        paciente.getDireccion().getCiudad(),
                        paciente.getDireccion().getNumero(),
                        paciente.getDireccion().getComplemento()));
        return ResponseEntity.ok(datosPaciente);
    }
}
