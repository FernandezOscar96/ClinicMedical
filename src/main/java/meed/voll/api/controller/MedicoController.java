package meed.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import meed.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid MedicDataReg MedicDataReg) {

        medicoRepository.save(new Medico(MedicDataReg));
    }

    @GetMapping
    public Page<MedicListData> listadoMedico(@PageableDefault(size = 2) Pageable paginacion) {
        //return medicoRepository.findAll(paginacion).map(MedicListData::new);
        return medicoRepository.findByActivoTrue(paginacion).map(MedicListData::new);

    }

    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid MedicActData medicActData) {
        Medico medico = medicoRepository.getReferenceById(medicActData.id());
        medico.actualizarDatos(medicActData);
    }

    //DELETE logico
    @DeleteMapping("/eliminarMedico/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();

    }



    /*
    DELETE en base de datos
    public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medicoRepository.delete(medico);
    }*/
}
