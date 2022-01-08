package com.papcenter.controller;

import com.papcenter.model.Notificacion;
import com.papcenter.service.MatronaService;
import com.papcenter.service.NotificacionService;
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
@RequestMapping("/notificacion")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @ApiOperation(value = "Obtener todos las cesfan",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "notificacions")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron notificacions en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public ResponseEntity<List<Notificacion>> listar() {
        List<Notificacion> lista = notificacionService.findAll();
        return new ResponseEntity<List<Notificacion>>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtener una notificacion",
            notes = "Necesita el id de entrada",
            response = List.class,
            responseContainer = "Notificacion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron notificacions en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Notificacion obj = notificacionService.findById(id);
        return new ResponseEntity<Notificacion>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Guarda una notificacion",
            notes = "Necesita ingresar los datos de la notificacion",
            response = List.class,
            responseContainer = "notificacions")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron notificacions en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Notificacion notificacion) {
        Notificacion obj = notificacionService.save(notificacion);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(notificacion.getIdNotificacion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Acualizar un notificacion",
            notes = "Necesita ingresar la notificacion a actualizar",
            response = List.class,
            responseContainer = "Notificacion")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encuentra la notificacions en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PutMapping
    public ResponseEntity<Notificacion> modificar(@Valid @RequestBody Notificacion notificacion) {
        Notificacion obj = notificacionService.update(notificacion);
        return new ResponseEntity<Notificacion>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Borra un notificacion",
            notes = "Necesita ingresar el id de la notificacion a eliminar",
            response = List.class,
            responseContainer = "notificacions")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, Notificacion no encontrado"),
            @ApiResponse(code = 405, message = "No se encuentra el paciente en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
        notificacionService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
