package com.papcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Información o propiedes del paciente")
@Entity
@Table(name = "t_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_paciente")
    private Integer idPaciente;

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

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "edad", length = 10)
    private Integer edad;

    @Column(name = "prevision", length = 20)
    private String prevision;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @Column(name = "email")
    @Email(message = "Debe ser un email valido")
    private String email;

    //@OneToMany(mappedBy = "idNotificacion", fetch = FetchType.LAZY, orphanRemoval = false, cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_fkid", referencedColumnName = "id_paciente")
    private List<Notificacion> listNotificaciones = new ArrayList<>();

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }



}
