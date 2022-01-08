package com.papcenter.controller;

import com.papcenter.model.Cesfam;
import com.papcenter.service.CesfamService;
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
@RequestMapping("/cesfam")
public class CesfamController {

    @Autowired
    private CesfamService cesfamService;

    @ApiOperation(value = "Obtener todos las cesfan",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Cesfams")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron cesfams en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public ResponseEntity<List<Cesfam>> listar() {
        List<Cesfam> lista = cesfamService.findAll();
        return new ResponseEntity<List<Cesfam>>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtener una cesfam",
            notes = "Necesita el id de entrada",
            response = List.class,
            responseContainer = "Cesfam")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron cesfams en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping("/{id}")
    public ResponseEntity<Cesfam> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Cesfam obj = cesfamService.findById(id);
        return new ResponseEntity<Cesfam>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Guarda una cesfam",
            notes = "Necesita ingresar los datos de la cesfam",
            response = List.class,
            responseContainer = "Cesfams")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron cesfams en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Cesfam cesfam) {
        Cesfam obj = cesfamService.save(cesfam);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cesfam.getIdCesfam()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Acualizar un cesfam",
            notes = "Necesita ingresar la cesfam a actualizar",
            response = List.class,
            responseContainer = "Cesfam")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encuentra la cesfams en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PutMapping
    public ResponseEntity<Cesfam> modificar(@Valid @RequestBody Cesfam cesfam) {
        Cesfam obj = cesfamService.update(cesfam);
        return new ResponseEntity<Cesfam>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Borra un cesfam",
            notes = "Necesita ingresar el id de la cesfam a eliminar",
            response = List.class,
            responseContainer = "Cesfams")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, cesfam no encontrado"),
            @ApiResponse(code = 405, message = "No se encuentra el paciente en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
        cesfamService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
