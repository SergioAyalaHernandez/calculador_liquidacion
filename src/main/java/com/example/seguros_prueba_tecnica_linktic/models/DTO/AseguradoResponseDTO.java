package com.example.seguros_prueba_tecnica_linktic.models.DTO;

import java.util.List;

public class AseguradoResponseDTO {

    private String tipoIdentificacion;
    private String nroIdentificacion;
    private Integer valorAsegurado;
    private List<AmparoDTO> liquidacion;
    private Float valorTotal;

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public Integer getValorAsegurado() {
        return valorAsegurado;
    }

    public void setValorAsegurado(Integer valorAsegurado) {
        this.valorAsegurado = valorAsegurado;
    }

    public List<AmparoDTO> getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(List<AmparoDTO> liquidacion) {
        this.liquidacion = liquidacion;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
