package com.papcenter.controller;

import com.papcenter.model.Matrona;
import com.papcenter.model.Paciente;
import com.papcenter.service.MatronaService;
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

    @GetMapping
    public ResponseEntity<List<Matrona>> listar() {
        List<Matrona> lista = matronaService.findAll();
        return new ResponseEntity<List<Matrona>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matrona> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Matrona obj = matronaService.findById(id);
        return new ResponseEntity<Matrona>(obj, HttpStatus.OK);
    }

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

    @PutMapping
    public ResponseEntity<Matrona> modificar(@Valid @RequestBody Matrona matrona) {
        Matrona obj = matronaService.update(matrona);
        return new ResponseEntity<Matrona>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
        matronaService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
