package meed.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import meed.voll.api.domain.direction.DirectionData;
import meed.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<RequestMedicData> registrarMedico(@RequestBody @Valid MedicDataReg MedicDataReg, UriComponentsBuilder uriComponentsBuilder) {
        Medico medico = medicoRepository.save(new Medico(MedicDataReg));
        RequestMedicData requestMedicData = new RequestMedicData(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getEspecialidad().toString(),
                new DirectionData(
                        medico.getDireccion().getCalle(),
                        medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),
                        medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento()));

        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(url).body(requestMedicData);
    }

    @GetMapping
    public ResponseEntity<Page<MedicListData>>  listadoMedico(@PageableDefault(size = 2) Pageable paginacion) {
        //return medicoRepository.findAll(paginacion).map(MedicListData::new);
        return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(MedicListData::new));

    }

    @PutMapping
    @Transactional
    public ResponseEntity<RequestMedicData> actualizarMedico(@RequestBody @Valid MedicActData medicActData) {
        Medico medico = medicoRepository.getReferenceById(medicActData.id());
        medico.actualizarDatos(medicActData);
        return ResponseEntity.ok(new RequestMedicData(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getEspecialidad().toString(),
                new DirectionData(
                        medico.getDireccion().getCalle(),
                        medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),
                        medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento())));
    }

    //DELETE logico
    @DeleteMapping("/eliminarMedico/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<RequestMedicData> returnMedicData(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        var datosMedicos = new RequestMedicData(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getEspecialidad().toString(),
                new DirectionData(
                        medico.getDireccion().getCalle(),
                        medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),
                        medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento()));
        return ResponseEntity.ok(datosMedicos);
    }
}
