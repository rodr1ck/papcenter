package com.papcenter.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class MatronaPacienteDTO implements Serializable {

    private Integer idMatrona;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Integer edad;
    private String prevision;
    private LocalDate fecha_nacimiento;

    public MatronaPacienteDTO() {
    }

    public MatronaPacienteDTO(Integer idMatrona, String nombres, String apellidos, String direccion, Integer edad, String prevision, LocalDate fecha_nacimiento) {
        this.idMatrona = idMatrona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.edad = edad;
        this.prevision = prevision;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getIdMatrona() {
        return idMatrona;
    }

    public void setIdMatrona(Integer idMatrona) {
        this.idMatrona = idMatrona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

}
