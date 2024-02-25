package com.example.seguros_prueba_tecnica_linktic.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Primas")
public class Prima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prima")
    private Integer idPrima;

    @ManyToOne
    @JoinColumn(name = "codigo_amparo", referencedColumnName = "id_amparo")
    private Amparo amparo;

    @Column(name = "edad_minima")
    private Integer edadMinima;
    @Column(name = "edad_maxima")
    private Integer edadMaxima;
    @Column(name = "porcentaje_prima")
    private Float porcentajePrima;


    public Integer getIdPrima() {
        return idPrima;
    }

    public void setIdPrima(Integer idPrima) {
        this.idPrima = idPrima;
    }

    public Amparo getAmparo() {
        return amparo;
    }

    public void setAmparo(Amparo amparo) {
        this.amparo = amparo;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public Integer getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(Integer edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public Float getPorcentajePrima() {
        return porcentajePrima;
    }

    public void setPorcentajePrima(Float porcentajePrima) {
        this.porcentajePrima = porcentajePrima;
    }
}