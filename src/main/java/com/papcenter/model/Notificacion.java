package com.papcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime fechayhora_pap;

    @ApiModelProperty(notes = "Fecha en que se realizara la notificacion del pap ")
    @Column(name = "fecha_notifacion")
    private LocalDateTime fechayhora_notifacion;

    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_matrona")
    private Integer idMatrona; */

    public Matrona getMatrona() {
        return matrona;
    }

    public void setMatrona(Matrona matrona) {
        this.matrona = matrona;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @ManyToOne
    @JoinColumn(name = "id_matrona", nullable = false, foreignKey = @ForeignKey(name = "FK_notificacion_matrona"))
    private Matrona matrona;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_notificacion_paciente"))
    private Paciente paciente;

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer id) {
        this.idNotificacion = id;
    }


    public LocalDateTime getFechayhora_pap() {
        return fechayhora_pap;
    }

    public void setFechayhora_pap(LocalDateTime fechayhora_pap) {
        this.fechayhora_pap = fechayhora_pap;
    }

    public LocalDateTime getFechayhora_notifacion() {
        return fechayhora_notifacion;
    }

    public void setFechayhora_notifacion(LocalDateTime fechayhora_notifacion) {
        this.fechayhora_notifacion = fechayhora_notifacion;
    }






}
