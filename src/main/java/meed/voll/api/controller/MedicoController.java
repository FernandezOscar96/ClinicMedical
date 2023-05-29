package meed.voll.api.controller;

import jakarta.validation.Valid;
import meed.voll.api.medico.MedicDataReg;
import meed.voll.api.medico.Medico;
import meed.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid MedicDataReg MedicDataReg) {

        medicoRepository.save(new Medico(MedicDataReg));
    }
}
