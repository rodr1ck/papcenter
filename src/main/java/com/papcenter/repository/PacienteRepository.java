package com.papcenter.repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.papcenter.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    public List<Paciente> findAll();

   // public Paciente findById(@Param("id") Integer id);

    public Paciente save(Paciente paciente);


    /* public Paciente findById(){

    } */

   /* public Paciente save(Paciente paciente){
        return paciente;
    } */

}
