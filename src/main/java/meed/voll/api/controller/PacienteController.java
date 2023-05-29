package meed.voll.api.controller;

import meed.voll.api.paciente.PacientDataReg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @PostMapping
    public void registrar(@RequestBody PacientDataReg datos){
        System.out.println(datos);

    }
}
