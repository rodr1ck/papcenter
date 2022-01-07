package com.papcenter.controller;

import com.papcenter.model.Paciente;
import com.papcenter.service.PacienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Obtener todos los pacientes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Pacientes")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron pacientes en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
   @GetMapping()
    public ResponseEntity<List<Paciente>> findAll(){
        return new ResponseEntity<>(pacienteService.findAll(), HttpStatus.OK);
    }

    /*@GetMapping
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }*/

    @ApiOperation(value = "Obtener un paciente",
            notes = "Necesita el id de entrada",
            response = List.class,
            responseContainer = "Paciente")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron pacientes en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping("/{id}")
    public Paciente findById(@PathVariable("id") Integer id){
        return pacienteService.findById(id);
    }


    @ApiOperation(value = "Guarda un paciente",
            notes = "Necesita ingresar los datos del paciente",
            response = List.class,
            responseContainer = "Pacientes")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron pacientes en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PostMapping
    public @ResponseBody Paciente save(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }

    @ApiOperation(value = "Borra un paciente",
            notes = "Necesita ingresar el id del paciente a eliminar",
            response = List.class,
            responseContainer = "Pacientes")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encuentra el paciente en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @DeleteMapping ("/{id}")
    public boolean deleteById(@PathVariable("id") Integer id){
        return pacienteService.delete(id);
    }

}
