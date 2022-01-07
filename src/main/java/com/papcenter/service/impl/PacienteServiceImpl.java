package com.papcenter.service.impl;

import com.papcenter.model.Paciente;
import com.papcenter.repository.PacienteRepository;
import com.papcenter.service.PacienteService;

import java.util.List;
import java.util.Optional;
import com.papcenter.exception.ModelNotFoundException;

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

   /* @Override
    public Paciente findById(Integer id) {
        Optional<Paciente> op = pacienteRepository.findById(id);
        return op.isPresent() ? op.get() : new Paciente();
    }*/

    @Override
    public Paciente findById(Integer id) {
        Optional<Paciente> op = pacienteRepository.findById(id);
        if(op.isPresent()){
            return op.get();
        }else{
            throw new ModelNotFoundException("Paciente no encontrado");
        }
    }

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente update(Paciente paciente) {
        return save(paciente);
    }

    @Override
    public boolean delete(Integer id) {
        pacienteRepository.deleteById(id);
        return true;
    }

}
