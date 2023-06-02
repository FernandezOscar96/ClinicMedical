package meed.voll.api.controller;

import jakarta.validation.Valid;
import meed.voll.api.paciente.PacientDataReg;
import meed.voll.api.paciente.PacientRepository;
import meed.voll.api.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacientRepository pacientRepository;
    @PostMapping
    public void registrar(@RequestBody @Valid PacientDataReg PacientDataReg){
        pacientRepository.save(new Paciente(PacientDataReg));
    }
}
