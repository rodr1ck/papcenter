package com.papcenter.controller;

import com.papcenter.dto.MatronaPacienteDTO;
import com.papcenter.service.MatronaPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatronaPacienteController {

    @Autowired
    private MatronaPacienteService matronaPacienteService;

    @GetMapping("/matrona-paciente")
    public List<MatronaPacienteDTO> getAllMatronaPaciente() {
        return matronaPacienteService.getAllMatronaPaciente();
    }

}
