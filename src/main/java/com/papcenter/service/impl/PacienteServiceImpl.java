package com.papcenter.service.impl;

import com.papcenter.model.Paciente;
import com.papcenter.repository.PacienteRepository;
import com.papcenter.service.PacienteService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente findById(Integer id) {
        Optional<Paciente> op = pacienteRepository.findById(id);
        return op.isPresent() ? op.get() : new Paciente();
    }

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

   /* @Override
    public List<Paciente> findByRut(String rut) {
        List<Paciente> pacientes = new ArrayList<>();
        if(rut != null && !"".equalsIgnoreCase(rut)){
            if(rut.equalsIgnoreCase("ALL")){
                pacientes = findAll();
            }else if(rut.equalsIgnoreCase("City")){
                //buscar todos los pacientes por la ciudad
                pacientes = findAll();
            }else{
                Paciente paciente = findById(1);
                pacientes.add(paciente);
            }
        }
        return pacientes;
    } */

}
