package com.papcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "Información o propiedes de la Matrona")
@Entity
@Table(name = "t_matrona")
public class Matrona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_matrona")
    private Integer idMatrona;

    @ApiModelProperty(notes = "Rut debe tener como minimo 8 caracteres")
    @Column(name = "rut", length = 15)
    @Size(min = 8, max = 15, message = "El rut debe tener un valor mayor a 8 digitos y menos a 15 digitos")
    private String rut;

    @ApiModelProperty(notes = "Nombre debe tener como minimo 3 caracteres")
    @Column(name = "nombres", length = 70)
    @Size(min = 3, max = 70, message = "El nombre debe tener un valor mayor a 3 digitos y menor a 70")
    private String nombres;

    @ApiModelProperty(notes = "Apellido debe tener como minimo 3 caracteres")
    @Column(name = "apellidos", length = 70)
    private String apellidos;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_fkid", referencedColumnName = "id_matrona")
    private List<Paciente> listPacientes = new ArrayList<>();

    public Integer getIdMatrona() {
        return idMatrona;
    }

    public void setIdMatrona(Integer id) {
        this.idMatrona = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellido) {
        this.apellidos = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Paciente> getListPacientes() {
        return listPacientes;
    }

    public void setListPacientes(List<Paciente> listPacientes) {
        this.listPacientes = listPacientes;
    }
}
