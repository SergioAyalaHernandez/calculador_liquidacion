package com.example.seguros_prueba_tecnica_linktic.models;

import java.util.List;

public class AseguradoReport {

    private String tipoIdentificación;
    private String numeroIdentificacion;
    private Float valorAsegurado;
    private List<Liquidacion> liquidacion;
    private Float valorTotal;

    public String getTipoIdentificación() {
        return tipoIdentificación;
    }

    public void setTipoIdentificación(String tipoIdentificación) {
        this.tipoIdentificación = tipoIdentificación;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Float getValorAsegurado() {
        return valorAsegurado;
    }

    public void setValorAsegurado(Float valorAsegurado) {
        this.valorAsegurado = valorAsegurado;
    }

    public List<Liquidacion> getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(List<Liquidacion> liquidacion) {
        this.liquidacion = liquidacion;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
