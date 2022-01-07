package com.papcenter.controller;

import com.papcenter.model.Paciente;
import com.papcenter.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

   /* @GetMapping()
    public ResponseEntity<List<Paciente>> findAll(){
        return new ResponseEntity<>(pacienteService.findAll(), HttpStatus.OK);
    }*/

    @GetMapping
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable("id") Integer id){
        return pacienteService.findById(id);
    }

    @PostMapping
    public @ResponseBody Paciente save(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }

}
