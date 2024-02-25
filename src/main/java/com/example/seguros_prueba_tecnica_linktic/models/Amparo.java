package com.example.seguros_prueba_tecnica_linktic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Amparos")
public class Amparo {
    @Id
    @Column(name = "id_amparo")
    private Integer idAmparo;
    private String nombre;

    public Integer getIdAmparo() {
        return idAmparo;
    }

    public void setIdAmparo(Integer idAmparo) {
        this.idAmparo = idAmparo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
