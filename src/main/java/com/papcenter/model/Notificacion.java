package com.papcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@ApiModel(description = "Información o propiedes de las notoficaciones")
@Entity
@Table(name = "t_notificacion")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idNotificacion;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaciente")
    private Integer pacienteId;*/

    @ApiModelProperty(notes = "fecha en que se realizara el pap")
    @Column(name = "fecha_pap")
    private LocalDate fecha_pap;

    @ApiModelProperty(notes = "Fecha en que se realizara la notificacion del pap ")
    @Column(name = "fecha_notifacion")
    private LocalDate fecha_notifacion;

    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_matrona")
    private Integer idMatrona; */

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer id) {
        this.idNotificacion = id;
    }

    /*public Integer getIdPaciente() {
        return pacienteId;
    }

    public void setIdPaciente(Integer id_paciente) {
        this.pacienteId = id_paciente;
    }*/

    public LocalDate getFecha_pap() {
        return fecha_pap;
    }

    public void setFecha_pap(LocalDate fecha_pap) {
        this.fecha_pap = fecha_pap;
    }

    public LocalDate getFecha_notifacion() {
        return fecha_notifacion;
    }

    public void setFecha_notifacion(LocalDate fecha_notifacion) {
        this.fecha_notifacion = fecha_notifacion;
    }

   /* public Integer getId_matrona() {
        return idMatrona;
    }

    public void setId_matrona(Integer id_matrona) {
        this.idMatrona = id_matrona;
    }*/


}
