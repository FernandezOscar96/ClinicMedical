package meed.voll.api.controller;

import meed.voll.api.medico.MedicDataReg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @PostMapping
    public void registrarMedico(@RequestBody MedicDataReg MedicDataReg){

        System.out.println(MedicDataReg);
    }
}
