package com.papcenter.controller;

import com.papcenter.model.Matrona;
import com.papcenter.model.Paciente;
import com.papcenter.service.MatronaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/matrona")
public class MatronaController {

    @Autowired
    private MatronaService matronaService;

    @ApiOperation(value = "Obtener todos las matronas",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Matronas")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron matronas en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public ResponseEntity<List<Matrona>> listar() {
        List<Matrona> lista = matronaService.findAll();
        return new ResponseEntity<List<Matrona>>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtener una matrona",
            notes = "Necesita el id de entrada",
            response = List.class,
            responseContainer = "Matrona")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron matronas en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping("/{id}")
    public ResponseEntity<Matrona> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Matrona obj = matronaService.findById(id);
        return new ResponseEntity<Matrona>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Guarda una matrona",
            notes = "Necesita ingresar los datos de la matrona",
            response = List.class,
            responseContainer = "Matronas")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron matronas en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Matrona matrona) {
        Matrona obj = matronaService.save(matrona);
        //medicos/4
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(matrona.getIdMatrona()).toUri();
        return ResponseEntity.created(location).build();
    }

   /* @PostMapping
    public @ResponseBody
    Matrona save(@RequestBody Matrona matrona){
        return matronaService.save(matrona);
    }*/

    @ApiOperation(value = "Acualizar un paciente",
            notes = "Necesita ingresar la matrona a actualizar",
            response = List.class,
            responseContainer = "Matrona")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encuentra la matrona en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PutMapping
    public ResponseEntity<Matrona> modificar(@Valid @RequestBody Matrona matrona) {
        Matrona obj = matronaService.update(matrona);
        return new ResponseEntity<Matrona>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Borra un matrona",
            notes = "Necesita ingresar el id de la matrona a eliminar",
            response = List.class,
            responseContainer = "Matronas")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, matrona no encontrada"),
            @ApiResponse(code = 405, message = "No se encuentra el paciente en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
        matronaService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
