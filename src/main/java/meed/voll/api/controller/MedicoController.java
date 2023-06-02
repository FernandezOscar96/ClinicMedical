package meed.voll.api.controller;

import jakarta.validation.Valid;
import meed.voll.api.medico.MedicDataReg;
import meed.voll.api.medico.MedicListData;
import meed.voll.api.medico.Medico;
import meed.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<MedicListData> listadoMedico() {
        return medicoRepository.findAll().stream().map(MedicListData::new).toList();
    }
}
