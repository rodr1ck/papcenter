package com.papcenter.service;

import com.papcenter.dto.MatronaPacienteDTO;
import com.papcenter.model.Paciente;
import com.papcenter.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatronaPacienteService {

    @Autowired
    private PacienteRepository matronapacienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<MatronaPacienteDTO> getAllMatronaPaciente() {
        return matronapacienteRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    private MatronaPacienteDTO convertEntityToDto(Paciente paciente) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        MatronaPacienteDTO matronaPacienteDTO = new MatronaPacienteDTO();
        matronaPacienteDTO = modelMapper.map(paciente, MatronaPacienteDTO.class);
        return matronaPacienteDTO;
    }

    private Paciente convertDtoToEntity(MatronaPacienteDTO matronaPacienteDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Paciente paciente = new Paciente();
        paciente = modelMapper.map(matronaPacienteDTO, Paciente.class);
        return paciente;
    }

}
