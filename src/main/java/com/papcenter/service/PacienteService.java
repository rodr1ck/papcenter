package com.papcenter.service;

import com.papcenter.model.Paciente;
import java.util.List;

public interface PacienteService {

    List<Paciente> findAll();

    Paciente findById(Integer id);

    Paciente save(Paciente paciente);

    //List<Paciente> findByRut(String rut);

}
