package com.example.seguros_prueba_tecnica_linktic.models;

import com.example.seguros_prueba_tecnica_linktic.models.DTO.AseguradoAmparoList;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Asegurados")
public class Asegurado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asegurado")
    private Integer idAsegurado;

    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;

    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;

    private String apellidos;
    private String nombres;
    private String sexo;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "asegurado")
    private List<AseguradoAmparoList> amparos;

    public Integer getIdAsegurado() {
        return idAsegurado;
    }

    public void setIdAsegurado(Integer idAsegurado) {
        this.idAsegurado = idAsegurado;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<AseguradoAmparoList> getAmparos() {
        return amparos;
    }

    public void setAmparos(List<AseguradoAmparoList> amparos) {
        this.amparos = amparos;
    }
}