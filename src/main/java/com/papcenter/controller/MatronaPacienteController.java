package com.papcenter.controller;

import com.papcenter.dto.MatronaPacienteDTO;
import com.papcenter.model.Paciente;
import com.papcenter.service.MatronaPacienteService;
import com.papcenter.service.MatronaService;
import com.papcenter.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MatronaPacienteController {

    @Autowired
    private MatronaPacienteService matronaPacienteService;

    @GetMapping("/matrona-paciente")
    public List<MatronaPacienteDTO> getAllMatronaPaciente(){
        return matronaPacienteService.getAllMatronaPaciente();
    }

/*
    public List<MatronaPacienteDTO> getAllMatronaPaciente(){

    }

    private MatronaPacienteDTO converEntityToDto (Paciente paciente){
        MatronaPacienteDTO matronaPacienteDTO = new MatronaPacienteDTO();
        matronaPacienteDTO.setIdMatrona(paciente.getMatrona().getIdMatrona());
        matronaPacienteDTO.setNombres(paciente.getMatrona().getNombres());
        matronaPacienteDTO.setApellidos(paciente.getMatrona().getApellidos());
        matronaPacienteDTO.setDireccion(paciente.getDireccion());
        matronaPacienteDTO.setEdad(paciente.getEdad());
        matronaPacienteDTO.setPrevision(paciente.getPrevision());
        matronaPacienteDTO.setFecha_nacimiento(paciente.getFecha_nacimiento());
        return matronaPacienteDTO;
    }*/

  /*  @GetMapping("/dto")
    public List<MatronaPacienteDTO> findAllDto(Paciente paciente){
        List<MatronaPacienteDTO> dtos = new ArrayList<>();
        List<Consulta> consultas = service.findAll();
        consultas.forEach(consulta -> {
            ConsultaDTO d = new ConsultaDTO();
            d.setIdConsulta(consulta.getIdConsulta());
            d.setNameMedico(consulta.getMedico().getNombres() + consulta.getMedico().getApellidos());
            d.setNameEspecialidad(consulta.getEspecialidad().getNombre());
            // localhost:0880/paciente/1
            ControllerLinkBuilder linkTo1 =
                    linkTo(methodOn(PacienteController.class).findById((consulta.getPaciente().getIdPaciente())));
            d.add(linkTo1.withSelfRel());

            // localhost:8080/medico/11
            ControllerLinkBuilder linkTo2 =
                    linkTo(methodOn(MedicoController.class).listarPorId((consulta.getMedico().getIdMedico())));
            d.add(linkTo2.withSelfRel());

            // localhost:8080/consultas/1
            ControllerLinkBuilder linkTo = linkTo(methodOn(ConsultaController.class).listarPorId((consulta.getIdConsulta())));
            d.add(linkTo.withSelfRel());

            dtos.add(d);
        });
        return dtos;
    } */

}
