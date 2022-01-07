package com.papcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@ApiModel(description = "Información o propiedes del Cesfam")
@Entity
@Table(name = "t_cesfam")
public class Cesfam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idCesfam;

    @ApiModelProperty(notes = "Nombre debe tener como minimo 3 caracteres")
    @Column(name = "nombre", length = 70)
    @Size(min = 3, max = 70, message = "El nombre debe tener un valor mayor a 3 digitos y menor a 70")
    private String nombre;

    @ApiModelProperty(notes = "Ciudad debe tener como minimo 3 caracteres")
    @Column(name = "ciudad", length = 70)
    @Size(min = 3, max = 70, message = "La ciudad debe tener un valor mayor a 3 digitos y menor a 70")
    private String ciudad;

    @ApiModelProperty(notes = "Region debe tener como minimo 3 caracteres")
    @Column(name = "region", length = 70)
    @Size(min = 3, max = 70, message = "La region debe tener un valor mayor a 3 digitos y menor a 70")
    private String region;

    @ApiModelProperty(notes = "Comuna debe tener como minimo 3 caracteres")
    @Column(name = "comuna", length = 70)
    @Size(min = 3, max = 70, message = "La comuna debe tener un valor mayor a 3 digitos y menor a 70")
    private String comuna;

    @ApiModelProperty(notes = "Servicio debe tener como minimo 3 caracteres")
    @Column(name = "servicio", length = 70)
    @Size(min = 3, max = 70, message = "El servicio debe tener un valor mayor a 3 digitos y menor a 70")
    private String servicio;

    @ApiModelProperty(notes = "Codigo debe tener como minimo 3 caracteres")
    @Column(name = "codigo", length = 70)
    @Size(min = 3, max = 70, message = "El codigo debe tener un valor mayor a 3 digitos y menor a 70")
    private String codigo;

    public Integer getIdCesfam() {
        return idCesfam;
    }

    public void setIdCesfam(Integer id) {
        this.idCesfam = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


}
